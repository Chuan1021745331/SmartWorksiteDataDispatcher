package com.hxjd.model;

import com.hxjd.model.ElevatorData;

/**
 * Time: 14:56
 * Date: 2017/9/20
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class ElevatorEvent
{
    private ElevatorData data;

    public ElevatorEvent(ElevatorData data)
    {
        this.data = data;
    }

    public ElevatorData getData()
    {
        return data;
    }

    public void setData(ElevatorData data)
    {
        this.data = data;
    }
}
