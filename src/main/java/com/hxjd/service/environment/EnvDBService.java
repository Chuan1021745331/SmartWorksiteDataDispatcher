package com.hxjd.service.environment;

import com.hxjd.dao.EnvDao;
import com.hxjd.model.EnvData;
import com.hxjd.utils.SDTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Time: 10:17 AM
 * Date: 10/12/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@Component
public class EnvDBService
{
    private final static Logger logger = LoggerFactory.getLogger(EnvDBService.class);

    @Autowired
    private EnvDao dao;

    public boolean save(EnvData data)
    {
        try
        {
            data.setRecordTime(LocalDateTime.now().format(SDTimeUtil.dateTimeFormatter));
            return dao.add(data);
        }
        catch(Exception e)
        {
            logger.error("保存环境数据失败" + e);
            return false;
        }
    }
}
