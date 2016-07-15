package com.github.jetqin.sychronized;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jet on 16/6/8.
 */
public class EventStorage
{
    private int maxSize;

    private List<Date> storage;

    public EventStorage()
    {
        maxSize = 10;
        storage = new LinkedList<Date>();
    }

    public synchronized void set()
    {

        while (storage.size() == maxSize)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.printf("Set:%d", storage.size());
        System.out.println();
        notifyAll();

    }

    public synchronized void get()
    {
        while (storage.size() == 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s", storage.size(), ((LinkedList<?>) storage).poll());
        System.out.println();
        notifyAll();
    }
}
