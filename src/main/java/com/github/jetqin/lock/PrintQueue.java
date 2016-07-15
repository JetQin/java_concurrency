package com.github.jetqin.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jet on 16/6/9.
 */
public class PrintQueue
{
    private final Lock queueLock = new ReentrantLock(false);

    public void printJob(Object documnet)
    {
        queueLock.lock();
        try
        {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":Block 1 PrintQueue: Printing a Job during " + (duration / 1000) +
                    " seconds");
            Thread.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            queueLock.unlock();
        }
        queueLock.lock();
        try
        {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":Block2 PrintQueue: Printing a Job during " + (duration / 1000) +
                    " seconds");
            Thread.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            queueLock.unlock();
        }
    }
}
