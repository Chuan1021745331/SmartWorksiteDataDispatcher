package com.hxjd.service.environment;

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
    private EnvData dataStr;

    public EnvEvent(EnvData dataStr)
    {
        this.dataStr = dataStr;
    }

    public EnvData getData()
    {
        return dataStr;
    }

    public void setData(EnvData dataStr)
    {
        this.dataStr = dataStr;
    }
}
