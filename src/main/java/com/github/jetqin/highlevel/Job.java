package com.github.jetqin.highlevel;

/**
 * Created by jet on 16/6/10.
 */
public class Job implements Runnable
{
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue){

        this.printQueue = printQueue;
    }


    public void run()
    {

        System.out.printf("%s: Going to print a job\n",Thread.
                currentThread().getName());
        printQueue.printJob(new Object());

    }
}
