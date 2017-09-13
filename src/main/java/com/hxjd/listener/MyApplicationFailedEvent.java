package com.hxjd.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Time: 20:46
 * Date: 2017/9/12
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 服务启动监听器，监听服务启动失败事件
 */
public class MyApplicationFailedEvent implements ApplicationListener<ApplicationFailedEvent>
{

    private final static Logger logger = LoggerFactory.getLogger(MyApplicationFailedEvent.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent)
    {
        logger.error(applicationFailedEvent.getException().getLocalizedMessage());
    }
}
