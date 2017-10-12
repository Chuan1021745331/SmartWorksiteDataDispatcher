package com.hxjd.model;

/**
 * Time: 9:00 PM
 * Date: 10/11/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class PakEvent
{
    private PakData data;

    public PakEvent(PakData data)
    {
        this.data = data;
    }

    public PakData getData()
    {
        return data;
    }

    public void setData(PakData data)
    {
        this.data = data;
    }
}
