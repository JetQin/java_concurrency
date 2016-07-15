package com.github.jetqin.highlevel;

/**
 * Created by jet on 16/6/10.
 */
public class Results
{
    private int data[];

    public Results(int size)
    {
        data = new int[size];
    }

    public void setData(int position, int value)
    {
        data[position] = value;
    }

    public int[] getData()
    {
        return data;
    }
}
