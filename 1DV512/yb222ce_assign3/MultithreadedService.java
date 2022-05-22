package yb222ce_assign3;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/*
 * File:	MultithreadedService.java
 * Course: 	20HT - Operating Systems - 1DV512
 * Author: 	Yetnayet Belachew and LNU student ID yb222ce.
 * Date: 	December 2021
 */

// TODO: put this source code file into a new Java package with meaningful name (e.g., dv512.YourStudentID)!

// You can implement additional fields and methods in code below, but
// you are not allowed to rename or remove any of it!

// Additionally, please remember that you are not allowed to use any third-party libraries

public class MultithreadedService {
	 // TODO: implement a nested public class titled Task here
    // which must have an integer ID and specified burst time (duration) in milliseconds,
    // see below
    // Add further fields and methods to it, if necessary
    // As the task is being executed for the specified burst time,
    // it is expected to simply go to sleep every X milliseconds (specified below)

    public LocalTime startingTime = null;

    public class Task implements Runnable{

        private int tid;
        private long bursttime;
        private LocalTime starttime;
        private LocalTime finishtime;
        private boolean intothequeue; // record if the task was ever assigned to thread

        public void run(){


            try {
                if(startingTime == null){
                    startingTime = LocalTime.now();
                }
                LocalTime currentTime = LocalTime.now();
                if(currentTime.until(startingTime, ChronoUnit.MILLIS) >= maxruntime) {
                    exe.shutdownNow();
                }

                if(!this.intothequeue){
                    this.intothequeue = true;
                    this.starttime =  LocalTime.now();
                }

                while(bursttimes[this.tid] > 0 && System.currentTimeMillis() - start < maxruntime){

                    Thread.sleep(sleeptime);
                    bursttimes[this.tid] -= 100L;

                    if(bursttimes[this.tid] == 0) {
                        this.finishtime = LocalTime.now();
                    }
                }

            } catch (InterruptedException e) {
                //Do nothing
            }
        }



        public void gotoSleep(long timemillis) throws InterruptedException {
            try {
                Thread.sleep(timemillis);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }

        public Task(int id,long btime){
            super();
            tid = id;
            bursttime = btime;
            starttime = finishtime = null;
            intothequeue = false;
        }


        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public long getBursttime() {
            return bursttime;
        }

        public void setBursttime(long bursttime) {
            this.bursttime = bursttime;
        }
    }



    // Random number generator that must be used for the simulation
    Random rng;

    // ... add further fields, methods, and even classes, if necessary
    ArrayList<Task> tasks = new ArrayList<>();

    long sleeptime;
    long[] bursttimes;
    long maxruntime;
    long start;

    ArrayList<Integer> interrupted = new ArrayList<>();
    ArrayList<Integer> completed = new ArrayList<>();
    ArrayList<Integer> waiting = new ArrayList<>();
    ExecutorService exe;

    public MultithreadedService (long rngSeed) {
        this.rng = new Random(rngSeed);
    }


   





	public void reset() {
        // TODO - remove any information from the previous simulation, if necessary
        if(tasks.size() != 0)
            tasks.clear();
        if(bursttimes != null)
            bursttimes = null;
        if(completed != null)
            completed.clear();
        if(waiting != null)
            waiting.clear();
        if(interrupted != null)
            interrupted.clear();

        startingTime = null;
    }


    // If the implementation requires your code to throw some exceptions,
    // you are allowed to add those to the signature of this method
    public void runNewSimulation(final long totalSimulationTimeMs,
                                 final int numThreads, final int numTasks,
                                 final long minBurstTimeMs, final long maxBurstTimeMs, final long sleepTimeMs) throws InterruptedException {
        reset();
        bursttimes = new long[numTasks];


        for(int i = 0 ; i<numTasks  ; i++){
            int _bt = rng.nextInt((int)((maxBurstTimeMs - minBurstTimeMs)/1000)) + (int)(minBurstTimeMs/1000);
            bursttimes[i] = _bt*1000L;
            tasks.add(new Task(i,_bt*1000L));
        }

        maxruntime = totalSimulationTimeMs;
        sleeptime = sleepTimeMs;
        start = System.currentTimeMillis();
        try {
            exe = Executors.newFixedThreadPool(numThreads); //fixedThreadPool
            int i = 0;

            while (i < numTasks) {
                exe.execute(tasks.get(i));
                i++;
            }
        } catch (Exception exception){
            // Doing nothing
        } finally {
            while (!exe.isTerminated()) {
                exe.shutdown();
            }
        }

        // simulations

        // TODO:
        // 1. Run the simulation for the specified time, totalSimulationTimeMs
        // 2. While the simulation is running, use a fixed thread pool with numThreads
        // (see https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/Executors.html#newFixedThreadPool(int) )
        // to execute Tasks (implement the respective class, see above!)
        // 3. The total maximum number of tasks is numTasks,
        // and each task has a burst time (duration) selected randomly
        // between minBurstTimeMs and maxBurstTimeMs (inclusive)
        // 4. The implementation should assign sequential task IDs to the created tasks (0, 1, 2...)
        // and it should assign them to threads in the same sequence (rather any other scheduling approach)
        // 5. When the simulation time is up, it should make sure to stop all of the currently executing
        // and waiting threads!

    }


    public void printResults() {
        for(int i = 0 ; i<bursttimes.length ; i++){
            if(bursttimes[i] == 0)
                completed.add(i);
            else if(bursttimes[i] < tasks.get(i).getBursttime() && bursttimes[i] > 0)
                interrupted.add(i);
            else
                waiting.add(i);

        }

        System.out.print("completed tasks :");
        System.out.println("\nID\tburst\tStart\t\t\t\tfinish\n");
        for(Integer i : completed)
            System.out.println(tasks.get(i).tid+"\t"+tasks.get(i).bursttime+"\t"+tasks.get(i).starttime+"\t"+tasks.get(i).finishtime);

        System.out.print("\ninterrupted tasks:\n");
        for(Integer i : interrupted)
            System.out.println("ID\t"+i);

        System.out.print("\nwaiting tasks:\n");
        for(Integer i : waiting)
            System.out.println("ID\t"+i);


    }

    // If the implementation requires your code to throw some exceptions,
    // you are allowed to add those to the signature of this method
    public static void main(String[] args) throws InterruptedException {
        // TODO: replace the seed value below with your birth date, e.g., "20001001"
        final long rngSeed = 19930606;

        // Do not modify the code below — instead, complete the implementation
        // of other methods!
        MultithreadedService service = new MultithreadedService(rngSeed);

        final int numSimulations = 3;
        final long totalSimulationTimeMs = 15*1000L; // 15 seconds

        final int numThreads = 4;
        final int numTasks = 30;
        final long minBurstTimeMs = 1000L; // 1 second
        final long maxBurstTimeMs = 10*1000L; // 10 seconds
        final long sleepTimeMs = 100L; // 100 ms

        for (int i = 0; i < numSimulations; i++) {
            System.out.println("Running simulation #" + i);

            service.runNewSimulation(totalSimulationTimeMs,
                    numThreads, numTasks,
                    minBurstTimeMs, maxBurstTimeMs, sleepTimeMs);

            System.out.println("Simulation results:"
                    + "\n" + "----------------------");
            service.printResults();

            System.out.println("\n");
        }

        System.out.println("----------------------");
        System.out.println("Exiting...");




        // If your program has not completed after the message printed above,
        // it means that some threads are not properly stopped! -> this issue will affect the grade
    }
}


