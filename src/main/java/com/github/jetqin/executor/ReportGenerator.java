package com.github.jetqin.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/7/12.
 */
public class ReportGenerator implements Callable<String>
{
    private String sender;
    private String title;

    public ReportGenerator(String sender, String title){
        this.sender=sender;
        this.title=title;
    }

    public String call() throws Exception
    {
        try
        {
            Long duration=(long)(Math.random()*10);
            System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n",this.sender,this.title,duration);
                    TimeUnit.SECONDS.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String ret=sender+": "+title;
        return ret;
    }
}
