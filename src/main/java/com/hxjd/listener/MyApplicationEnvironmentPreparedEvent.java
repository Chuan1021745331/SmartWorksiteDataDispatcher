package com.hxjd.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Time: 20:45
 * Date: 2017/9/12
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 服务启动监听器，监听环境准备事件
 */
public class MyApplicationEnvironmentPreparedEvent implements ApplicationListener<ApplicationEnvironmentPreparedEvent>
{
    private final static Logger logger = LoggerFactory.getLogger(MyApplicationEnvironmentPreparedEvent.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent)
    {

    }
}
