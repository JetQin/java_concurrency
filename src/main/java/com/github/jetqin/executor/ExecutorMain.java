package com.github.jetqin.executor;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by jet on 16/6/11.
 */
public class ExecutorMain
{
    public static void main(String[] args)
    {
//        ThreadPoolExecutor Example
//        Server server = new Server();
//        for (int i = 0; i < 10; i++)
//        {
//            Task task = new Task("Task " + i);
//            server.executeTask(task);
//        }
//        server.endServer();

//        Callable example

//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
//
//        Random random = new Random();
//        for (int index = 0; index < 10; index++)
//        {
//            Integer number = random.nextInt(10);
//            FactorialCalculator calculator = new FactorialCalculator(number);
//            Future<Integer> result = executor.submit(calculator);
//            resultList.add(result);
//        }
//        do
//        {
//            System.out.printf("Main: Number of Completed Tasks:%d\n", executor.getCompletedTaskCount());
//            for (int i = 0; i < resultList.size(); i++)
//            {
//                Future<Integer> result = resultList.get(i);
//                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
//            }
//            try
//            {
//                TimeUnit.MILLISECONDS.sleep(50);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//
//        }
//        while (executor.getCompletedTaskCount() < resultList.size());
//        System.out.printf("Main: Results\n");
//        for (int i = 0; i < resultList.size(); i++)
//        {
//            Future<Integer> result = resultList.get(i);
//            Integer number = null;
//            try
//            {
//                number = result.get();
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//            catch (ExecutionException e)
//            {
//                e.printStackTrace();
//            }
//            System.out.printf("Main: Task %d: %d\n", i, number);
//        }
//
//        executor.shutdown();
//    }

//        Callable Example2
//        String username="test";
//        String password="test";
//        UserValidator ldapValidator=new UserValidator("LDAP");
//        UserValidator dbValidator=new UserValidator("DataBase");
//        TaskValidator ldapTask=new TaskValidator(ldapValidator,
//                username, password);
//        TaskValidator dbTask=new TaskValidator(dbValidator,username,password);
//        List<TaskValidator> taskList = new ArrayList<TaskValidator>();
//        taskList.add(ldapTask);
//        taskList.add(dbTask);
//        ExecutorService executor=(ExecutorService)Executors.newCachedThreadPool();
//        String result;
//        try {
//            result = executor.invokeAny(taskList);
//            System.out.printf("Main: Result: %s\n",result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        executor.shutdown();
//        System.out.printf("Main: End of the Execution\n");

//        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
//        System.out.printf("Main: Starting at: %s\n", new Date());
//        for (int i = 0; i < 5; i++)
//        {
//            TaskCallable task = new TaskCallable("Task " + i);
//            executor.schedule(task, i + 1, TimeUnit.SECONDS);
//        }
//        executor.shutdown();
//        try
//        {
//            executor.awaitTermination(1, TimeUnit.DAYS);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//        System.out.printf("Main: Ends at: %s\n",new Date());

//Separated Executor Task

        ExecutorService executor=(ExecutorService)Executors.newCachedThreadPool();
        CompletionService<String> service=new ExecutorCompletionService<String>(executor);
        ReportRequest faceRequest=new ReportRequest("Face", service);
        ReportRequest onlineRequest=new ReportRequest("Online", service);
        Thread faceThread=new Thread(faceRequest);
        Thread onlineThread=new Thread(onlineRequest);
        ReportProcessor processor=new ReportProcessor(service);
        Thread senderThread=new Thread(processor);
        System.out.printf("Main: Starting the Threads\n");
        faceThread.start();
        onlineThread.start();
        senderThread.start();
        try {
            System.out.printf("Main: Waiting for the report generators.\n");
            faceThread.join();
            onlineThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Shutting down the executor.\n");
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        processor.setEnd(true);
        System.out.println("Main: Ends");
    }
}
