package com.hxjd.service.elevator;

import com.hxjd.dao.ElevatorDao;
import com.hxjd.dao.EnvDao;
import com.hxjd.model.ElevatorData;
import com.hxjd.service.environment.EnvDBService;
import com.hxjd.utils.SDTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Time: 10:28 AM
 * Date: 10/12/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@Component
public class ElevatorDBService
{
    private final static Logger logger = LoggerFactory.getLogger(ElevatorDBService.class);

    @Autowired
    private ElevatorDao dao;

    public void save(ElevatorData data)
    {
        logger.info("开始保存升降机数据");
        try
        {
            data.setRecordTime(LocalDateTime.now().format(SDTimeUtil.dateTimeFormatter));
            dao.add(data);
            logger.info("升降机数据保存成功");
        }
        catch(Exception e)
        {
            logger.error("升降机数据保存失败" + e);
        }
    }
}
