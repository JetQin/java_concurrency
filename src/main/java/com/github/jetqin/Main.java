package com.github.jetqin;

import com.github.jetqin.runnable.SafeTask;
import com.github.jetqin.runnable.SearchTask;

import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/6/5.
 */
public class Main
{
    public static void main(String[] args)
    {
//        DataSourceLoader dsLoader = new DataSourceLoader();
//        Thread thread1 = new Thread(dsLoader, "DataSourceThread");
//
//        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
//        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");
//
//        thread1.start();
//        thread2.start();
//
//        try
//        {
//            thread1.join();
//            thread2.join();
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//
//        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());


//        Deque<Event> deque=new ArrayDeque<Event>();
//        WriterTask writer=new WriterTask(deque);
//        for (int i=0; i<3; i++){
//            Thread thread=new Thread(writer);
//            thread.start();
//        }
//        CleanerTask cleaner=new CleanerTask(deque);
//        cleaner.start();

//        Task task=new Task();
//        Thread thread=new Thread(task);
//        thread.setUncaughtExceptionHandler(new ExceptionHandler());
//        thread.start();

//        UnsafeTask task = new UnsafeTask();
//        for (int i = 0; i < 10; i++)
//        {
//            Thread thread = new Thread(task);
//            thread.start();
//            try
//            {
//                TimeUnit.SECONDS.sleep(2);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }

//        SafeTask task = new SafeTask();
//        for (int i = 0; i < 10; i++)
//        {
//            Thread thread = new Thread(task);
//            thread.start();
//            try
//            {
//                TimeUnit.SECONDS.sleep(2);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }


//        ThreadGroup threadGroup = new ThreadGroup("Searcher");
//        Result result = new Result();
//        SearchTask searchTask = new SearchTask(result);
//        for (int i = 0; i < 5; i++)
//        {
//            Thread thread = new Thread(threadGroup, searchTask);
//            thread.start();
//            try
//            {
//                TimeUnit.SECONDS.sleep(1);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
//        System.out.printf("Information about the Thread Group\n");
//        threadGroup.list();
//        Thread[] threads = new Thread[threadGroup.activeCount()];
//        threadGroup.enumerate(threads);
//        for (int i = 0; i < threadGroup.activeCount(); i++)
//        {
//            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
//        }
//        waitFinish(threadGroup);
//        threadGroup.interrupt();
//
//    }
//
//    private static void waitFinish(ThreadGroup threadGroup)
//    {
//        while (threadGroup.activeCount() > 9)
//        {
//            try
//            {
//                TimeUnit.SECONDS.sleep(1);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
    }
}
