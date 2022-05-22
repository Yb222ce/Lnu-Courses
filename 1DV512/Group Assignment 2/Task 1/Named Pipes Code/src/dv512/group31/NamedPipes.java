package dv512.group31;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

/*
 * File:	NamedPipes.java
 * Course: 	20HT - Operating Systems - 1DV512
 * Author: 	Mohammad Sheikh Yousef
 * Date: 	December 2020
 * Group number 31
 */

public class NamedPipes
{
    static private List<String> pipeList;
    static private final int timeStampStartIndex = 31;
    static private final int timeStampEndIndex = 2;

    static public void main(String[] args) throws InterruptedException, IOException {
        /*
        Step 1 Print All Information Of Processes
         */
        System.out.println("=============== Step 1 ===============");
        Stream<ProcessHandle> processHandleStream = ProcessHandle.allProcesses();
        processHandleStream.forEach(NamedPipes::printAllProcesses);

        /*
        Step 2 Attempt to open test_named_pipe
         */
        System.out.println("=============== Step 2 ===============");
        attemptPipe();
    }

    static private void attemptPipe() throws InterruptedException, IOException {
        while (true)
        {
            pipeList = new ArrayList<>();
            Stream<ProcessHandle> processHandleStream = ProcessHandle.allProcesses();
            processHandleStream.forEach(NamedPipes::checkAllProcesses);
            for (String temp : pipeList)
                System.out.println(temp);
            readPipe();
            Thread.sleep(3000);
            System.out.println("---------------------------------------");
        }
    }

    static private void printAllProcesses(ProcessHandle processHandle)
    {
        String timeStamp = "";
        String[] info = processHandle.info().toString().split(",");
        for (String temp : info)
        {
            temp = temp.strip();
            if (temp.startsWith("startTime:"))
                timeStamp = temp;
        }
        if (timeStamp.isEmpty())
            return;
        timeStamp = getTimeStamp(timeStamp);
        System.out.println("<PID " + processHandle.pid() + "> <" + timeStamp + "> Process started");
    }

    static private void checkAllProcesses(ProcessHandle processHandle)
    {
        String pipeInfo = processHandle.info().toString();
        if (!pipeInfo.contains("pipe"))
            return;
        String[] info = pipeInfo.split(",");
        for (String temp : info)
        {
            temp = temp.strip();
            if (temp.startsWith("startTime:"))
                pipeInfo = temp;
        }
        pipeInfo = getTimeStamp(pipeInfo);
        pipeList.add("<PID " + processHandle.pid() + "> <" + pipeInfo + "> Pipe opened");
    }

    static private void readPipe() throws IOException {
        FileReader fileReader = new FileReader("test_named_pipe");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Pipe Open
        long pipeID = ProcessHandle.current().pid();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.");
        // getMillis
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime start = now.truncatedTo(ChronoUnit.DAYS);
        long millis = ChronoUnit.MILLIS.between(start, now);
        millis = millis % 1000;
        System.out.println("<PID " + pipeID + "> <" + simpleDateFormat.format(calendar.getTime()) + millis + "> Pipe opened");

        // Read line by line
        String readLine = bufferedReader.readLine();
        while (readLine != null)
        {
            System.out.println(readLine);
            readLine = bufferedReader.readLine();
        }

        fileReader.close();
        // Pipe Close
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss.");
        // getMillis
        now = ZonedDateTime.now();
        start = now.truncatedTo(ChronoUnit.DAYS);
        millis = ChronoUnit.MILLIS.between(start, now);
        millis = millis % 1000;
        System.out.println("<PID " + pipeID + "> <" + simpleDateFormat.format(calendar.getTime()) + millis + "> Pipe closed");
    }

    static private String getTimeStamp(String info)
    {
        String timeStamp;
        timeStamp = info.substring(timeStampStartIndex, info.length() - timeStampEndIndex);
        return timeStamp;
    }
}
