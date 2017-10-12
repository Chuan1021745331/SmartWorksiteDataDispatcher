package com.hxjd.model;

/**
 * Time: 9:07 PM
 * Date: 10/11/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class MonitorEvent
{
    private MonitorData data;

    public MonitorEvent(MonitorData data)
    {
        this.data = data;
    }

    public MonitorData getData()
    {
        return data;
    }

    public void setData(MonitorData data)
    {
        this.data = data;
    }
}
