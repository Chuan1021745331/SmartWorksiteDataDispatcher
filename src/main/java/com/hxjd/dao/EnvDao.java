package com.hxjd.dao;

import com.hxjd.model.BaseData;
import com.hxjd.model.EnvData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Time: 10:02 PM
 * Date: 10/11/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@Mapper
public interface EnvDao
{
    @Insert("insert into environment_data(project_code, device_id, source_id, device_code, record_time, temperature, humidity, pm2p5, pm10, noise, wind_speed, wind_direction, serial_no)" +
            " values(#{projectCode}, #{deviceId}, #{sourceId}, #{deviceCode}, #{recordTime}, #{temperature}, #{humidity}, #{pm2p5}, #{pm10}, #{noise}, #{windSpeed}, #{windDirection}, #{serialNo})")
    boolean add(EnvData data);
}
