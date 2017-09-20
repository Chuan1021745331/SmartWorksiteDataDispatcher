package com.hxjd.model;

/**
 * Time: 11:15
 * Date: 2017/9/19
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public abstract class BaseData
{
    private String projectCode = "5001132017081501417001";//项目唯一编码
    private String deviceId = "4DF9D516-7E62-4F3A-9ABE-E08B5088EF18";//设备id
    private String sourceId = "9b2db993-857f-11e7-857d-00163e32d704";//来源数据id，外部系统跟踪数据用
    private String deviceCode = "ASD0000X0001";//设备物理编号
    private String recordTime = "";//采集时间

    public String getProjectCode()
    {
        return projectCode;
    }

    public void setProjectCode(String projectCode)
    {
        this.projectCode = projectCode;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getSourceId()
    {
        return sourceId;
    }

    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }

    public String getDeviceCode()
    {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }

    public String getRecordTime()
    {
        return recordTime;
    }

    public void setRecordTime(String recordTime)
    {
        this.recordTime = recordTime;
    }
}
