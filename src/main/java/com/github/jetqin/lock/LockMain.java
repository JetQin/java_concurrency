package com.github.jetqin.lock;


import java.io.File;

/**
 * Created by jet on 16/6/9.
 */
public class LockMain
{
    public static void main(String[] args)
    {
//        PrintQueue printQueue = new PrintQueue();
//        Thread thread[] = new Thread[10];
//        for (int i = 0; i < 10; i++)
//        {
//            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
//        }
//        for (int i = 0; i < 10; i++)
//        {
//            thread[i].start();
//        }

//        PriceInfo priceInfo = new PriceInfo();
//        Reader[] readers = new Reader[5];
//        Thread[] threadReaders = new Thread[5];
//        for (int index = 0; index < 5; index++)
//        {
//            readers[index] = new Reader(priceInfo);
//            threadReaders[index] = new Thread(readers[index]);
//        }
//
//        Writer writer = new Writer(priceInfo);
//        Thread threadWriter = new Thread(writer);
//
//        for (int index = 0; index < 5; index++)
//        {
//            threadReaders[index].start();
//        }
//        threadWriter.start();

//        PrintQueue printQueue = new PrintQueue();
//        Thread thread[] = new Thread[10];
//        for (int i = 0; i < 10; i++)
//        {
//            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
//        }
//        for (int i = 0; i < 10; i++)
//        {
//            thread[i].start();
//            try
//            {
//                Thread.sleep(100);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }

        //Condition Lock

        FileMock mock = new FileMock(100,10);
        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(mock,buffer);
        Thread threadProducer = new Thread(producer,"Producer");

        Consumer consumers[] = new Consumer[3];
        Thread[] threadConsumer = new Thread[3];

        for (int index = 0; index < 3; index++)
        {
            consumers[index] = new Consumer(buffer);
            threadConsumer[index] = new Thread(consumers[index],"Consumers"+index);
        }

        threadProducer.start();
        for (int index = 0; index < 3; index++)
        {
            threadConsumer[index].start();
        }

    }
}
