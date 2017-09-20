package com.hxjd.web;

import com.alibaba.fastjson.JSON;
import com.hxjd.model.DataRealTimeMessage;
import com.hxjd.model.DataRealTimeMessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Time: 23:21
 * Date: 2017/9/13
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@ServerEndpoint("/dataRealTime")
@Component
public class DataRealTimeWebSocket
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<DataRealTimeWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) throws IOException
    {
        this.session = session;
        webSocketSet.add(this);
        logger.info("数据同步界面已连接");
    }

    @OnClose
    public void onClose() throws IOException
    {
        webSocketSet.remove(this);
        for(DataRealTimeWebSocket item : webSocketSet)
        {
            logger.info("数据同步界面已关闭");
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException
    {

    }

    private void send(String data)
    {
        try
        {
            this.session.getBasicRemote().sendText(data);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void sendMessage(DataRealTimeMessage message)
    {
        for(DataRealTimeWebSocket dw : webSocketSet)
        {
            dw.send(JSON.toJSONString(message));
        }
    }
}
