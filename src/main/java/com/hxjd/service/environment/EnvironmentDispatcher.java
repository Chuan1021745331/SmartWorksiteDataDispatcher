package com.hxjd.service.environment;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.utils.AuthenticationUtil;
import com.hxjd.web.IndexController;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

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
        if (instance == null)
        {
            synchronized (EnvironmentDispatcher.class)
            {
                if (instance == null)
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
        /*/
        String url = "http://192.168.0.168:8080/api/v1/env/runtime";
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("projectCode", "5001132017081501417001")
                .add("deviceId", "4DF9D516-7E62-4F3A-9ABE-E08B5088EF18")
                .add("sourceId", "9b2db993-857f-11e7-857d-00163e32d704")
                .add("deviceCode", "ASD0000X0001")
                .add("serialNo", "ASD0000X0001")
                .add("temperature", "39.0")
                .add("humidity", "23.0")
                .add("pm2p5", "35.2")
                .add("pm10", "27.9")
                .add("noise", "63.5")
                .add("windSpeed", "23.0")
                .add("windDirection", "274")
                .add("recordTime", "20170811132025")
                .build();

        Request request = new Request.Builder().headers(AuthenticationUtil.getHeaders()).url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback()
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
            }
        });
        //*/
        logger.debug("环境监测");
    }
}
