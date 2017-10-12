package com.hxjd.service.pinganka;

import com.hxjd.dao.PakDao;
import com.hxjd.model.PakData;
import com.hxjd.service.environment.EnvDBService;
import com.hxjd.utils.SDTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Time: 11:13 AM
 * Date: 10/12/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@Component
public class PakDBService
{
    private final static Logger logger = LoggerFactory.getLogger(EnvDBService.class);

    @Autowired
    private PakDao dao;

    public void save(PakData data)
    {
        try
        {
            data.setRecordTime(LocalDateTime.now().format(SDTimeUtil.dateTimeFormatter));
            dao.add(data);
        }
        catch(Exception e)
        {
            logger.error("保存考勤数据失败" + e);
        }
    }
}
