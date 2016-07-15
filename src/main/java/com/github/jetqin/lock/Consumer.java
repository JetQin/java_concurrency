package com.github.jetqin.lock;

import java.util.Random;

/**
 * Created by jet on 16/6/10.
 */
public class Consumer implements Runnable
{

    private Buffer buffer;

    public Consumer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    public void run()
    {
        while (buffer.hasPendingLines())
        {
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line)
    {
        try
        {
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
