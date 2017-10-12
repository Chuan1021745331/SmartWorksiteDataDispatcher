package com.hxjd.listener;

import com.hxjd.receiver.socket.DispatcherCenterSocket;
import com.hxjd.receiver.socket.netty.DataReceiveServer;
import com.hxjd.utils.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * Time: 20:48
 * Date: 2017/9/12
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 服务启动监听器，监听服务就绪事件
 */
public class MyApplicationReadyEvent implements ApplicationListener<ApplicationReadyEvent>
{
    private final static Logger logger = LoggerFactory.getLogger(MyApplicationReadyEvent.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent)
    {
        ApplicationContextUtil.applicationContext = applicationReadyEvent.getApplicationContext();

        DataReceiveServer.getInstance().start();

        logger.info("启动成功");
    }
}
