package com.hxjd.dao;

import com.hxjd.model.ElevatorData;
import com.hxjd.model.EnvData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Time: 10:01 PM
 * Date: 10/11/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@Mapper
public interface ElevatorDao
{
    @Insert("insert into elevator_data(project_code, device_id, source_id, device_code, record_time, start_time, stop_time, people_number, start_height, stop_height, speed, `load`, load_percent, direction, status, warning_type, warning_msg)" +
            " values(#{projectCode}, #{deviceId}, #{sourceId}, #{deviceCode}, #{recordTime}, #{startTime}, #{stopTime}, #{peopleNumber}, #{startHeight}, #{stopHeight}, #{speed}, #{load}, #{loadPercent}, #{direction}, #{status}, #{warningType}, #{warningMsg})")
    boolean add(ElevatorData data);
}
