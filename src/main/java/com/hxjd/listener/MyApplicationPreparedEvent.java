package com.hxjd.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Time: 20:47
 * Date: 2017/9/12
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 服务启动监听器，监听服务准备事件
 */
public class MyApplicationPreparedEvent implements ApplicationListener<ApplicationPreparedEvent>
{
    private final static Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEvent.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent)
    {

    }
}
