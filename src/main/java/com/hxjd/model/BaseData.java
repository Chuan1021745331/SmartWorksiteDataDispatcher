package com.hxjd.model;

import com.hxjd.utils.SDTimeUtil;

import java.time.LocalDateTime;

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
    private String projectCode = "2B62B933-2E18-482C-8751-1DE795AE3A1F";//项目唯一编码
    private String deviceId = "null";//设备id
    private String sourceId = "null";//来源数据id，外部系统跟踪数据用
    private String deviceCode = "null";//设备物理编号
    private String recordTime = "null";//采集时间

    public BaseData()
    {
        this.recordTime = LocalDateTime.now().format(SDTimeUtil.dateTimeFormatter);
    }

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
