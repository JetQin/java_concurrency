package com.github.jetqin.executor;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by jet on 16/6/14.
 */
public class TaskCallable implements Callable<String>
{
    private String name;

    public TaskCallable(String name)
    {
        this.name = name;
    }

    public String call() throws Exception
    {
        System.out.printf("%s: Starting at : %s\n",name,new Date());
        return "Hello, world";
    }

}
