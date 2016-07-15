package com.github.jetqin.sychronized;


/**
 * Created by jet on 16/6/8.
 */
public class Consumer implements Runnable
{
    private EventStorage storage;

    public Consumer(EventStorage storage){
        this.storage = storage;
    }

    public void run()
    {
        for (int i=0; i<100; i++){
            storage.get();
        }
    }
}
