package com.github.jetqin.runnable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/6/5.
 */
public class DataSourceLoader implements Runnable
{
    public void run()
    {
        System.out.printf("Beginning data sources loading: %s\n", new Date());
        try
        {
            TimeUnit.SECONDS.sleep(4);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n",new Date());
    }
}
