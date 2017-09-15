package com.hxjd.utils;

import com.google.common.eventbus.EventBus;
import com.hxjd.service.authentication.AuthenticationDispatcher;
import com.hxjd.service.environment.EnvironmentDispatcher;

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
    private static volatile EventBusUtil instance = null;

    private EventBusUtil()
    {
        this.register(AuthenticationDispatcher.getInstance());
        this.register(EnvironmentDispatcher.getInstance());
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
}
