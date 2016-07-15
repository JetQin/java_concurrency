package com.github.jetqin.highlevel;

import java.util.concurrent.TimeUnit;

/**
 * Created by jet on 16/6/10.
 */
public class Participant implements Runnable
{
    private Videoconference conference;

    private String name;

    public Participant(Videoconference conference, String name)
    {
        this.conference = conference;
        this.name = name;
    }

    public void run()
    {
        long duration = (long) (Math.random() * 10);
        try
        {
            TimeUnit.SECONDS.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        conference.arrive(name);
    }
}
