package com.github.jetqin.executor;

import java.util.concurrent.CompletionService;

/**
 * Created by jet on 16/7/12.
 */
public class ReportRequest implements Runnable
{
    private String name;

    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String>
            service){
        this.name=name;
        this.service=service;
    }

    public void run()
    {
        ReportGenerator reportGenerator=new ReportGenerator(name,"Report");
        service.submit(reportGenerator);
    }
}
