package com.hxjd.model;

import com.hxjd.utils.StringUtil;

/**
 * Time: 10:58
 * Date: 2017/9/18
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class EnvData extends BaseData
{
    private String temperature = "null";
    private String humidity = "null";
    private String pm2p5 = "null";
    private String pm10 = "null";
    private String noise = "null";
    private String windSpeed = "null";
    private String windDirection = "null";
    private String serialNo = "null";

    public String getTemperature()
    {
        return temperature;
    }

    public void setTemperature(String temperature)
    {
        if(StringUtil.isEmpty(temperature))
        {
            this.temperature = "0";
            return;
        }
        this.temperature = temperature;
    }

    public String getHumidity()
    {
        return humidity;
    }

    public void setHumidity(String humidity)
    {
        this.humidity = humidity;
    }

    public String getPm2p5()
    {
        return pm2p5;
    }

    public void setPm2p5(String pm2p5)
    {
        this.pm2p5 = pm2p5;
    }

    public String getPm10()
    {
        return pm10;
    }

    public void setPm10(String pm10)
    {
        this.pm10 = pm10;
    }

    public String getNoise()
    {
        return noise;
    }

    public void setNoise(String noise)
    {
        this.noise = noise;
    }

    public String getWindSpeed()
    {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed)
    {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection()
    {
        return windDirection;
    }

    public void setWindDirection(String windDirection)
    {
        this.windDirection = windDirection;
    }

    public String getSerialNo()
    {
        return serialNo;
    }

    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }
}
