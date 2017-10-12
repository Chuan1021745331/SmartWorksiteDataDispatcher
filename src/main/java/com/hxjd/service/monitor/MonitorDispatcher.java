package com.hxjd.service.monitor;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.model.EnvEvent;
import com.hxjd.model.MonitorEvent;
import com.hxjd.service.pinganka.PakDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Time: 9:07 PM
 * Date: 10/11/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class MonitorDispatcher
{
    private final static Logger logger = LoggerFactory.getLogger(MonitorDispatcher.class);
    private static volatile MonitorDispatcher instance = null;

    private MonitorDispatcher()
    {
    }

    public static MonitorDispatcher getInstance()
    {
        if(instance == null)
        {
            synchronized(MonitorDispatcher.class)
            {
                if(instance == null)
                {
                    instance = new MonitorDispatcher();
                }
            }
        }
        return instance;
    }

    @Subscribe
    @AllowConcurrentEvents
    public void dispatch(MonitorEvent event)
    {

    }
}
