package com.hxjd.service.authentication;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.handler.web.IndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Time: 11:49
 * Date: 2017/9/14
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class AuthenticationDispatcher
{
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    private static volatile AuthenticationDispatcher instance = null;

    private AuthenticationDispatcher()
    {
    }

    public static AuthenticationDispatcher getInstance()
    {
        if (instance == null)
        {
            synchronized (AuthenticationDispatcher.class)
            {
                if (instance == null)
                {
                    instance = new AuthenticationDispatcher();
                }
            }
        }
        return instance;
    }

    @Subscribe
    @AllowConcurrentEvents
    public void dispatch(AuthEvent event)
    {
        logger.debug("鉴权");
    }
}
