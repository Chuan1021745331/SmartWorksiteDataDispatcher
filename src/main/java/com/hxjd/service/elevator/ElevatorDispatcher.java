package com.hxjd.service.elevator;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.model.ElevatorEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Time: 14:58
 * Date: 2017/9/20
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class ElevatorDispatcher
{
    private final static Logger logger = LoggerFactory.getLogger(ElevatorDispatcher.class);
    private static volatile ElevatorDispatcher instance = null;

    private ElevatorDispatcher()
    {
    }

    public static ElevatorDispatcher getInstance()
    {
        if(instance == null)
        {
            synchronized(ElevatorDispatcher.class)
            {
                if(instance == null)
                {
                    instance = new ElevatorDispatcher();
                }
            }
        }
        return instance;
    }

    @Subscribe
    @AllowConcurrentEvents
    public void dispatch(ElevatorEvent event)
    {

    }
}
