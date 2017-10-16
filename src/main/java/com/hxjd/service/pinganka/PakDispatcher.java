package com.hxjd.service.pinganka;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.model.PakEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Time: 9:01 PM
 * Date: 10/11/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class PakDispatcher
{
    private final static Logger logger = LoggerFactory.getLogger(PakDispatcher.class);
    private static volatile PakDispatcher instance = null;

    private PakDispatcher()
    {
    }

    public static PakDispatcher getInstance()
    {
        if(instance == null)
        {
            synchronized(PakDispatcher.class)
            {
                if(instance == null)
                {
                    instance = new PakDispatcher();
                }
            }
        }
        return instance;
    }

    @Subscribe
    @AllowConcurrentEvents
    public void dispatch(PakEvent event)
    {

    }
}
