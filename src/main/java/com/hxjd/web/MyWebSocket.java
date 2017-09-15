package com.hxjd.web;

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
@ServerEndpoint("/my-websocket")
@Component
public class MyWebSocket {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) throws IOException
    {
        this.session = session;
        webSocketSet.add(this);
        incrOnlineCount();
        for(MyWebSocket item : webSocketSet){
            if(!item.equals(this)) { //send to others only.
                item.sendMessage("someone just joined in.");
            }
        }
        logger.info("new connection...current online count: {}", getOnlineCount());
    }

    @OnClose
    public void onClose() throws IOException{
        webSocketSet.remove(this);
        decOnlineCount();
        for(MyWebSocket item : webSocketSet){
            item.sendMessage("someone just closed a connection.");
        }
        logger.info("one connection closed...current online count: {}", getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        logger.info("message received: {}", message);
        // broadcast received message
        for(MyWebSocket item : webSocketSet){
            item.sendMessage("服务器：" + message);
        }
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount(){
        return MyWebSocket.onlineCount;
    }

    public static synchronized void incrOnlineCount(){
        MyWebSocket.onlineCount++;
    }

    public static synchronized void decOnlineCount(){
        MyWebSocket.onlineCount--;
    }
}
