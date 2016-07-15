package com.github.jetqin.highlevel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by jet on 16/6/10.
 */
public class Searcher implements Runnable
{
    private final CyclicBarrier barrier;
    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results results;
    private int number;

    public Searcher(CyclicBarrier barrier, int firstRow, int lastRow, MatrixMock mock, Results results, int number)
    {
        this.barrier = barrier;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
    }

    public void run()
    {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);
        for (int i = firstRow; i < lastRow; i++)
        {
            int row[] = mock.getRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++)
            {
                if (row[j] == number)
                {
                    counter++;
                }
            }
            results.setData(i, counter);
        }
        System.out.printf("%s: Lines processed.\n",Thread.currentThread().getName());
        try
        {
            barrier.await();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }

}
