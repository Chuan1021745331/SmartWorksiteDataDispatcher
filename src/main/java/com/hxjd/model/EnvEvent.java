package com.hxjd.model;

import com.hxjd.model.EnvData;

/**
 * Time: 14:36
 * Date: 2017/9/15
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class EnvEvent
{
    private EnvData data;

    public EnvEvent(EnvData data)
    {
        this.data = data;
    }

    public EnvData getData()
    {
        return data;
    }

    public void setData(EnvData data)
    {
        this.data = data;
    }
}
