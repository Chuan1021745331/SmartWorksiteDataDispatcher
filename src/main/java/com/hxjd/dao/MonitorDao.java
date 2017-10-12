package com.hxjd.dao;

import com.hxjd.model.EnvData;
import com.hxjd.model.MonitorData;
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
public interface MonitorDao
{
    @Insert("insert into monitor_data(project_code, device_id, source_id, device_code, record_time, cover_url, play_url, cam_no, status)" +
            " values(#{projectCode}, #{deviceId}, #{sourceId}, #{deviceCode}, #{recordTime}, #{coverUrl}, #{playUrl}, #{camNo}, #{status})")
    boolean add(MonitorData data);
}
