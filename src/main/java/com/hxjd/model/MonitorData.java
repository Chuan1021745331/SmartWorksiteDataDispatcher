package com.hxjd.model;

/**
 * Time: 4:27 PM
 * Date: 10/9/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class MonitorData extends BaseData
{
    private String coverUrl = "null";
    private String playUrl = "null";
    private String camNo = "null";
    private String status = "null";

    public String getCoverUrl()
    {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl)
    {
        this.coverUrl = coverUrl;
    }

    public String getPlayUrl()
    {
        return playUrl;
    }

    public void setPlayUrl(String playUrl)
    {
        this.playUrl = playUrl;
    }

    public String getCamNo()
    {
        return camNo;
    }

    public void setCamNo(String camNo)
    {
        this.camNo = camNo;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
