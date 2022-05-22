package yb222ce_assign2;


import java.util.ArrayList;
import java.util.Random;

/*
 * File:	RandomScheduling.java
 * Course: 	20HT - Operating Systems - 1DV512
 * Author: 	Yetnayet Belachew and LNU student ID Yb222ce.
 * Date: 	January 2022
 */

// TODO: put this source code file into a new Java package with meaningful name (e.g., dv512.YourStudentID)!

// You can implement additional fields and methods in code below, but
// you are not allowed to rename or remove any of it!

// Additionally, please remember that you are not allowed to use any third-party libraries

public class RandomScheduling {
	
	public static class ScheduledProcess {
		int processId;
		int burstTime;
		int arrivalMoment;
		int time_before_finish;
		
		// The total time the process has waited since its arrival
		int totalWaitingTime;
		
		// The total CPU time the process has used so far
		// (when equal to burstTime -> the process is complete!)
		int allocatedCpuTime;

		public ScheduledProcess(int processId, int burstTime, int arrivalMoment) {
			this.processId = processId;
			this.burstTime = burstTime;
			this.arrivalMoment = arrivalMoment;
		}
		
		// ... add further fields and methods, if necessary
	}
		
	// Random number generator that must be used for the simulation
	Random rng;

	// ... add further fields and methods, if necessary
		
	public RandomScheduling(long rngSeed) {
		this.rng = new Random(rngSeed);
	}
	
	public void reset() {
		//TODO - remove any information from the previous simulation, if necessary
        processes.clear();
        completed_processes.clear();
        time_ticks = 0;
	}
	
    int time_ticks;										
    ArrayList<ScheduledProcess> 
        processes = new ArrayList<>(),                      //Total Scheduled processes
        completed_processes = new ArrayList<>();           // Completed processes list
    
	
    public void runNewSimulation(final boolean isPreemptive, final int timeQuantum,
	    final int numProcesses,
		final int minBurstTime, final int maxBurstTime,
		final int maxArrivalsPerTick, final double probArrival){
            
        reset();
		
        int process_ids = 0;
        ScheduledProcess current_process = null;

        if(!isPreemptive){
            while(true){
			
					//Add processes if process_ids less then numProcesses
						
						for(int i = 0 ; (i < maxArrivalsPerTick) && (process_ids < numProcesses) ; i++){
							
							// if chance > 0.5 then add process to queue
							if(this.rng.nextDouble() >= probArrival){
								int btime = this.rng.nextInt();
								processes.add(new ScheduledProcess(process_ids++,btime ,time_ticks));
							}
						}
						

						// if CPU is idle assign random process to cpu
						if(current_process == null && !processes.isEmpty()){
							current_process = processes.get(this.rng.nextInt(processes.size()));
							current_process.totalWaitingTime = time_ticks;
						}
						
						if(current_process != null){
							current_process.allocatedCpuTime++;
							if(current_process.allocatedCpuTime == current_process.burstTime){
								completed_processes.add(current_process);
								processes.remove(current_process);
								current_process = null;                //process is completed, CPU is idle now
							}
								
						}

						// break out of loop if all processes are completed
						if(completed_processes.size() == numProcesses){
							break;
						}
						
						time_ticks++;
					}
        }else{
			while(true){
			
				
				//Add processes if process_ids less then numProcesses
					
					for(int i = 0 ; (i < maxArrivalsPerTick) && (process_ids < numProcesses) ; i++){
						
						// if chance > 0.5 then add process to queue
						if(this.rng.nextDouble() >= probArrival){
							int btime = this.rng.nextInt();
							processes.add(new ScheduledProcess(process_ids++,btime ,time_ticks));
						}
					}
					

					// if CPU is idle assign random process to cpu
					if(current_process == null && !processes.isEmpty()){
						current_process = processes.get(this.rng.nextInt(processes.size()));
						current_process.totalWaitingTime += (time_ticks - current_process.time_before_finish);
					}


					
					if(current_process != null){

						// run a process it timequantam times
						for(int i = 0 ; i<timeQuantum ; i++){
							time_ticks++;
							current_process.allocatedCpuTime++;
							if(current_process.allocatedCpuTime == current_process.burstTime){
								completed_processes.add(current_process);
								processes.remove(current_process);
								current_process.time_before_finish = time_ticks;
								current_process = null;  //process is completed, CPU is idle now

								break;              
							}
						}
						if(current_process != null){
							current_process.time_before_finish = time_ticks;    //
							current_process = null;			// leave process (preempt process) after running it for time Quantam
						}
					}

					// break out of loop if all processes are completed
					if(completed_processes.size() == numProcesses){
						break;
					}
					
				}
		}

        }  	

		

               
    public void printResults() {
		// TODO:
		// 1. For each process, print its ID, burst time, arrival time, and total waiting time
		// 2. Afterwards, print the complete execution time of the simulation
		// and the average process waiting time

        int sum = 0;
		System.out.println("ID\tBurst\tArrival\t Total Waiting Time\n-------------------------------------------");
        for(ScheduledProcess p :completed_processes){
            System.out.println(p.processId + "\t  " + p.burstTime + "\t   " + p.arrivalMoment + "\t\t" + p.totalWaitingTime);
            sum += p.totalWaitingTime;
        }
        
        System.out.println("\nTotal simulation time :\t" + ++time_ticks +"\nAverage Total Waiting Time :\t"+sum/completed_processes.size()+"\n");

	}
		
	
	public static void main(String args[]) {
		//  TODO: replace the seed value below with your birth date, e.g., "20001001"
		final long rngSeed = 19930606;  
		
		
		// Do not modify the code below — instead, complete the implementation
		// of other methods!
		RandomScheduling scheduler = new RandomScheduling(rngSeed);
		
		final int numSimulations = 5;
		
		final int numProcesses = 10;
		final int minBurstTime = 2;
		final int maxBurstTime = 10;
		final int maxArrivalsPerTick = 2;
		final double probArrival = 0.75;
		
		final int timeQuantum = 2;

		boolean[] preemptionOptions = {false, true};

		for (boolean isPreemptive: preemptionOptions) {

			for (int i = 0; i < numSimulations; i++) {
				System.out.println("Running " + ((isPreemptive) ? "preemptive" : "non-preemptive")
					+ " simulation #" + i);

				scheduler.runNewSimulation(
					isPreemptive, timeQuantum,
					numProcesses,
					minBurstTime, maxBurstTime,
					maxArrivalsPerTick, probArrival);

				System.out.println("Simulation results:"
					+ "\n" + "----------------------");	
				scheduler.printResults();

				System.out.println("\n");
			}
		}		
		
	}
	
}

