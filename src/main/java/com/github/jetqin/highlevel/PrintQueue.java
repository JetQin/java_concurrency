package com.github.jetqin.highlevel;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jet on 16/6/10.
 */
public class PrintQueue
{
    private final Semaphore semaphore;
    private boolean freePrinters[];
    private Lock lockPrinters;

    public PrintQueue()
    {
        //non-fair or fair mode
        semaphore = new Semaphore(3, true);
        freePrinters = new boolean[3];
        for (int index = 0; index < 3; index++)
        {
            freePrinters[index] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document)
    {
        try
        {
            semaphore.acquire();

            int assignedPrinter = getPrinter();

            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", Thread.currentThread().getName(),
                    assignedPrinter, duration);

            Thread.sleep(duration);
            freePrinters[assignedPrinter] = true;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            semaphore.release();
        }
    }


    public int getPrinter()
    {
        int ret = -1;

        try
        {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++)
            {
                if (freePrinters[i])
                {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lockPrinters.unlock();
        }
        return ret;
    }
}
