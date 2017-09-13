package com.hxjd.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * Time: 20:49
 * Date: 2017/9/12
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 服务启动监听器，监听服务正在启动事件
 */
public class MyApplicationStartingEvent implements ApplicationListener<ApplicationStartingEvent>
{
    private final static Logger logger = LoggerFactory.getLogger(MyApplicationStartingEvent.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent)
    {

    }
}
