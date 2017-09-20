package com.hxjd.utils;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.hxjd.service.authentication.AuthenticationDispatcher;
import com.hxjd.service.environment.EnvironmentDispatcher;
import com.hxjd.web.DispatcherCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Time: 14:27
 * Date: 2017/9/15
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class EventBusUtil extends EventBus
{
    private final static Logger logger = LoggerFactory.getLogger(EventBusUtil.class);
    private static volatile EventBusUtil instance = null;

    private EventBusUtil()
    {
        //触发鉴权
        this.register(AuthenticationDispatcher.getInstance());
        //触发环境数据转发
        this.register(EnvironmentDispatcher.getInstance());
        //未处理事件
        this.register(new DeadEventHandler());
    }

    public static EventBusUtil getInstance()
    {
        if (instance == null)
        {
            synchronized (EventBusUtil.class)
            {
                if (instance == null)
                {
                    instance = new EventBusUtil();
                }
            }
        }
        return instance;
    }

    private class DeadEventHandler
    {
        @Subscribe
        @AllowConcurrentEvents
        public void deadEvent(DeadEvent event)
        {
            logger.debug("未处理EventBus事件");
        }
    }
}
