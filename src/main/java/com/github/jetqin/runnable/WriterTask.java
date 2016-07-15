package com.github.jetqin.runnable;

import com.github.jetqin.Event;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/6/5.
 */
public class WriterTask implements Runnable
{
    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque)
    {
        this.deque = deque;
    }

    public void run()
    {
        for (int index = 0; index < 100; index++)
        {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));
            deque.addFirst(event);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
