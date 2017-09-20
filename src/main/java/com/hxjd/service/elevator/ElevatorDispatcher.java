package com.hxjd.service.elevator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.model.EnvData;
import com.hxjd.model.ResultCode;
import com.hxjd.service.environment.EnvEvent;
import com.hxjd.service.environment.EnvironmentDispatcher;
import com.hxjd.utils.http.SmartHttp;
import com.hxjd.web.IndexController;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
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
    public void dispatch(EnvEvent event)
    {

    }
}
