package com.hxjd.service.environment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.model.*;
import com.hxjd.utils.http.SmartHttp;
import com.hxjd.web.DataRealTimeWebSocket;
import com.hxjd.web.IndexController;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Time: 16:26
 * Date: 2017/9/14
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class EnvironmentDispatcher
{

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    private static volatile EnvironmentDispatcher instance = null;

    private EnvironmentDispatcher()
    {
    }

    public static EnvironmentDispatcher getInstance()
    {
        if(instance == null)
        {
            synchronized(EnvironmentDispatcher.class)
            {
                if(instance == null)
                {
                    instance = new EnvironmentDispatcher();
                }
            }
        }
        return instance;
    }

    @Subscribe
    @AllowConcurrentEvents
    public void dispatch(EnvEvent event)
    {
        EnvData data = event.getData();
        List<EnvData> dataList = new ArrayList<>();
        dataList.add(data);
        /*/
        String url = "http://192.168.0.235:8080/api/v1/env/runtime";
        SmartHttp.post(url).json(JSON.toJSONString(dataList)).execute(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                System.out.println("连接超时");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                System.out.println("收到服务器反馈：" + response.body().string());
                JSONObject result = JSON.parseObject(response.body().string());
                int statusCode = result.getInteger("statusCode");

                //如果成功发送给建委，则将发送的数据同步到数据监控界面
                if(ResultCode.Normal.isEquals(statusCode))
                {
                    sendToFrontEnd(data);
                }
            }
        });
        /*/
        sendToFrontEnd(data);
        //*/
        logger.debug("环境监测");

    }

    private void sendToFrontEnd(EnvData data)
    {
        DataRealTimeMessage message = new DataRealTimeMessage();
        message.setType(DataRealTimeMessageType.ENVIRONMENT);
        message.setValue(JSON.toJSONString(JSON.toJSONString(data)));

        DataRealTimeWebSocket.sendMessage(message);
    }
}
