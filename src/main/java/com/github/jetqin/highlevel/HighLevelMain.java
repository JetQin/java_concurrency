package com.github.jetqin.highlevel;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

/**
 * Created by jet on 16/6/10.
 */
public class HighLevelMain
{
    public static void main(String[] args)
    {
//Semaphore Example
//        PrintQueue printQueue = new PrintQueue();
//
//        Thread[] threads = new Thread[10];
//
//        for (int index = 0; index < 10; index++)
//        {
//            threads[index] = new Thread(new Job(printQueue), "Thread" + index);
//        }
//        for (int i = 0; i < 10; i++)
//        {
//            threads[i].start();
//        }

//        CountDownLatch Example
//        Videoconference conference = new Videoconference(10);
//        Thread threadConference = new Thread(conference);
//        threadConference.start();
//
//        for (int index = 0; index < 10; index++)
//        {
//            Participant p = new Participant(conference,"Participant"+index);
//            Thread t = new Thread(p);
//            t.start();
//        }

//        CyclicBarrier Example

//        final int ROWS=10000;
//        final int NUMBERS=1000;
//        final int SEARCH=5;
//        final int PARTICIPANTS=5;
//        final int LINES_PARTICIPANT=2000;
//
//        MatrixMock mock=new MatrixMock(ROWS, NUMBERS,SEARCH);
//        Results results=new Results(ROWS);
//        Grouper grouper=new Grouper(results);
//        CyclicBarrier barrier=new CyclicBarrier(PARTICIPANTS,grouper);
//
//        Searcher searchers[]=new Searcher[PARTICIPANTS];
//        for (int i=0; i<PARTICIPANTS; i++)
//        {
//            searchers[i] = new Searcher(barrier,i*LINES_PARTICIPANT,(i*LINES_PARTICIPANT)+LINES_PARTICIPANT,mock,results,5);
//            Thread thread = new Thread(searchers[i]);
//            thread.start();
//        }
//        System.out.printf("Main: The main thread has finished.\n");

//        Phaser Example

        Phaser phaser=new Phaser(3);
        FileSearch system = new FileSearch("/Users/jet/Downloads", "log", phaser);
        FileSearch apps= new FileSearch("/Users/jet/Downloads","log",phaser);
        FileSearch documents = new FileSearch("/Users/jet/Downloads","log",phaser);
        Thread systemThread=new Thread(system,"System");
        systemThread.start();
        Thread appsThread=new Thread(apps,"Apps");
        appsThread.start();
        Thread documentsThread=new Thread(documents, "Documents");
        documentsThread.start();
        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Terminated: "+ phaser.isTerminated());

    }
}
