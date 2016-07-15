package com.github.jetqin.lock;

/**
 * Created by jet on 16/6/9.
 */
public class Reader implements Runnable
{
    private  PriceInfo priceInfo;

    public  Reader(PriceInfo priceInfo){
        this.priceInfo = priceInfo;
    }

    public void run()
    {
        for (int i=0; i<10; i++){
            System.out.printf("%s: Price 1: %f\n", Thread.
                    currentThread().getName(),priceInfo.getPrice1());
            System.out.printf("%s: Price 2: %f\n", Thread.
                    currentThread().getName(),priceInfo.getPrice2());
        }
    }
}
