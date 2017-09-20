package com.hxjd.model;

/**
 * Time: 9:49
 * Date: 2017/9/19
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class ElevatorData extends BaseData
{
    private String startTime;//开始工作时间
    private String stopTime;//停止工作时间
    private String peopleNumber;//运载人数
    private String startHeight;//开始运行高度
    private String stopHeight;//停止运行高度
    private String speed;//运行速度
    private String load;//本次运行载重
    private String loadPercent;//本次运行最大载重百分比
    private String direction;//运行方向，1:上升,2:下降
    private String status;//状态, 1：预警
    private String warningType;//预警类别: 0：预警(warning) 1：违章(illegal) 2：其他(other)
    private String warningMsg;//预警消息

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getStopTime()
    {
        return stopTime;
    }

    public void setStopTime(String stopTime)
    {
        this.stopTime = stopTime;
    }

    public String getPeopleNumber()
    {
        return peopleNumber;
    }

    public void setPeopleNumber(String peopleNumber)
    {
        this.peopleNumber = peopleNumber;
    }

    public String getStartHeight()
    {
        return startHeight;
    }

    public void setStartHeight(String startHeight)
    {
        this.startHeight = startHeight;
    }

    public String getStopHeight()
    {
        return stopHeight;
    }

    public void setStopHeight(String stopHeight)
    {
        this.stopHeight = stopHeight;
    }

    public String getSpeed()
    {
        return speed;
    }

    public void setSpeed(String speed)
    {
        this.speed = speed;
    }

    public String getLoad()
    {
        return load;
    }

    public void setLoad(String load)
    {
        this.load = load;
    }

    public String getLoadPercent()
    {
        return loadPercent;
    }

    public void setLoadPercent(String loadPercent)
    {
        this.loadPercent = loadPercent;
    }

    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getWarningType()
    {
        return warningType;
    }

    public void setWarningType(String warningType)
    {
        this.warningType = warningType;
    }

    public String getWarningMsg()
    {
        return warningMsg;
    }

    public void setWarningMsg(String warningMsg)
    {
        this.warningMsg = warningMsg;
    }
}
