package com.hxjd.service.environment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.hxjd.config.UrlConfig;
import com.hxjd.model.*;
import com.hxjd.handler.web.DataRealTimeWebSocket;
import com.hxjd.utils.AuthenticationUtil;
import com.hxjd.utils.http.SmartHttp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
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
    private final static Logger logger = LoggerFactory.getLogger(EnvironmentDispatcher.class);
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
        //*/
        SmartHttp.post(UrlConfig.ENV)
                .headers(AuthenticationUtil.getHeaders())
                .json(JSON.toJSONString(dataList)).execute(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                System.out.println("连接超时");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                //System.out.println("收到服务器反馈：" + response.body().string());
                String resultStr = response.body().string();
                JSONObject result = JSON.parseObject(resultStr);
                int statusCode = result.getInteger("statusCode");

                //如果成功则直接发送给建委并将发送的数据同步到数据监控界面，否则记录日志并添加提示后同步到数据监控界面
                if(!ResultCode.Normal.isEquals(statusCode))
                {
                    //状态码不为0的都进入此逻辑
                    JSONArray details = result.getJSONObject("content").getJSONArray("detailMsg");

                    String detailsStr = "";

                    for(int i = 0; i < details.size(); i++)
                    {
                        detailsStr += details.getString(i) + "　";
                    }

                    data.dispatchError();//标识数据为发送至建委失败

                    logger.error(result.getString("errMsg") + detailsStr);
                }

                sendToFrontEnd(data);
            }
        });
        /*/
        sendToFrontEnd(data);
        //*/
    }

    private void sendToFrontEnd(EnvData data)
    {
        DataRealTimeMessage message = new DataRealTimeMessage();
        message.setType(DataRealTimeMessageType.ENVIRONMENT);
        message.setValue(JSON.toJSONString(JSON.toJSONString(data)));

        DataRealTimeWebSocket.sendMessage(message);
    }
}
