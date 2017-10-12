package com.hxjd.dao;

import com.hxjd.model.PakData;
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
public interface PakDao
{
    @Insert("insert into pak_data(project_code, device_id, source_id, device_code, record_time, card_no, status)" +
            " values(#{projectCode}, #{deviceId}, #{sourceId}, #{deviceCode}, #{recordTime}, #{cardNo}, #{status})")
    boolean add(PakData data);
}
