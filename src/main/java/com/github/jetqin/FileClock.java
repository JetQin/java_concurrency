package com.github.jetqin;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/6/5.
 */
public class FileClock implements Runnable
{
    public static void main(String[] args)
    {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();
        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.printf("%s\n", new Date());
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                System.out.printf("The FileClock has been interrupted");
            }
        }
    }
}
