package com.github.jetqin.sychronized;

import com.github.jetqin.Event;

/**
 * Created by jet on 16/6/8.
 */
public class Producer implements Runnable
{
    private EventStorage storage;

    public Producer(EventStorage storage){
        this.storage = storage;
    }

    public void run()
    {
        for (int i=0; i<100; i++){
            storage.set();
        }
    }
}
