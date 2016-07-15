package com.github.jetqin.runnable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/6/5.
 */
public class NetworkConnectionsLoader implements Runnable
{
    public void run()
    {
        System.out.printf("Beginning network connection loading: %s\n", new Date());
        try
        {
            TimeUnit.SECONDS.sleep(6);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.printf("network connection  loading has finished: %s\n",new Date());
    }
}
