package com.hxjd.model;

/**
 * Time: 9:54
 * Date: 2017/9/18
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public enum DataRealTimeMessageType
{
    AUTH("temperature", 0, "鉴权"),
    ENVIRONMENT("humidity", 1, "环境监测"),
    ELEVATOR("pm2p5", 2, "升降机"),
    MONITOR("pm10", 3, "视频监控");

    private String name;
    private int value;
    private String explanation;

    DataRealTimeMessageType(String name, int value, String explanation)
    {
        this.name = name;
        this.value = value;
        this.explanation = explanation;
    }

    public String getName()
    {
        return this.name;
    }

    public int getValue()
    {
        return this.value;
    }

    public String getExplanation()
    {
        return this.explanation;
    }
}
