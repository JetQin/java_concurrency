package com.github.jetqin;

import java.util.Date;

/**
 * Created by jet on 16/6/5.
 */
public class Event
{
    private Date date;

    private String event;

    public Date getDate()
    {
        return date;
    }

    public String getEvent()
    {
        return event;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }
}
