package com.hxjd.model;

/**
 * Time: 9:54
 * Date: 2017/9/18
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class DataRealTimeMessage
{
    private DataRealTimeMessageType type;
    private String value;

    public DataRealTimeMessage()
    {
    }

    public DataRealTimeMessage(DataRealTimeMessageType type, String value)
    {
        this.type = type;
        this.value = value;
    }

    public DataRealTimeMessageType getType()
    {
        return type;
    }

    public void setType(DataRealTimeMessageType type)
    {
        this.type = type;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
