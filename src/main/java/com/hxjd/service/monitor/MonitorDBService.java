package com.hxjd.service.monitor;

import com.hxjd.dao.EnvDao;
import com.hxjd.dao.MonitorDao;
import com.hxjd.model.EnvData;
import com.hxjd.model.MonitorData;
import com.hxjd.service.environment.EnvDBService;
import com.hxjd.utils.SDTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Time: 11:37 AM
 * Date: 10/12/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@Component
public class MonitorDBService
{
    private final static Logger logger = LoggerFactory.getLogger(EnvDBService.class);

    @Autowired
    private MonitorDao dao;

    public void save(MonitorData data)
    {
        try
        {
            data.setRecordTime(LocalDateTime.now().format(SDTimeUtil.dateTimeFormatter));
            dao.add(data);
        }
        catch(Exception e)
        {
            logger.error("保存监控数据失败" + e);
        }
    }
}
