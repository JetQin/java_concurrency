package com.github.jetqin.lock;

/**
 * Created by jet on 16/6/10.
 */
public class FileMock
{
    private String content[];
    private int index;

    public FileMock(int size, int length)
    {
        content = new String[size];
        for (int index = 0; index < size; index++)
        {
            StringBuilder builder = new StringBuilder(length);
            for (int i = 0; i < length; i++)
            {
                int indice = (int) Math.random() * 255;
                builder.append((char) indice);
            }
            content[index] = builder.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines()
    {
        return index < content.length;
    }

    public String getLine()
    {
        if (this.hasMoreLines())
        {
            System.out.println("Mock:" + (content.length - index));
            return content[index++];
        }
        return null;
    }
}
