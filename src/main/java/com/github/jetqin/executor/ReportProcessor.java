package com.github.jetqin.executor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/7/12.
 */
public class ReportProcessor implements Runnable
{
    private CompletionService<String> service;

    private boolean end;

    public ReportProcessor (CompletionService<String> service)
    {
        this.service=service;
        end=false;
    }

    public void run()
    {
        while (!end)
        {
            try {
                Future<String> result=service.poll(20, TimeUnit.SECONDS);
                if (result!=null) {
                    String report=result.get();
                    System.out.printf("ReportReceiver: Report Received:%s\n",report);
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("ReportSender: End\n");

    }

    public void setEnd(boolean end)
    {
        this.end = end;
    }
}
