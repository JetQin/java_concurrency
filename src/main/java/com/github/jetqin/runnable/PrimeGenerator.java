package com.github.jetqin.runnable;

/**
 * Created by jet on 16/6/5.
 */
public class PrimeGenerator extends Thread
{

    public static void main(String[] args)
    {
        Thread task = new PrimeGenerator();
        task.start();
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        task.interrupt();
    }

    @Override
    public void run()
    {
        super.run();
        long number = 2L;
        while (true)
        {
            if (isPrime(number))
            {
                System.out.printf("Number %d is Prime", number);
                System.out.println();
            }
            if (isInterrupted())
            {
                System.out.println("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number)
    {
        if (number <= 2)
        {
            return true;
        }
        for (long i = 2; i < number; i++)
        {
            if ((number % i) == 0)
            {
                return false;
            }
        }
        return true;
    }
}
