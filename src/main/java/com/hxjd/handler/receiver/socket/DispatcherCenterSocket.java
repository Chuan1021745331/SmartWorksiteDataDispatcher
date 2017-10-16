package com.hxjd.handler.receiver.socket;

import com.hxjd.model.EnvData;
import com.hxjd.handler.receiver.socket.netty.DataReceiveServerHandler;
import com.hxjd.service.environment.EnvDBService;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hxjd.utils.ApplicationContextUtil.applicationContext;

/**
 * Time: 11:45
 * Date: 2017/9/15
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 硬件数据处理类（socket方式）
 */
public class DispatcherCenterSocket extends DataReceiveServerHandler
{
    private final static Logger logger = LoggerFactory.getLogger(DispatcherCenterSocket.class);


    public void start()
    {
        EnvDBService envDBService = applicationContext.getBean(EnvDBService.class);
        EnvData envData = new EnvData();
        envData.setRecordTime("hhhhhh");
        envData.setHumidity("a");
        logger.debug(envDBService.save(envData) + "");
    }

    @Override
    protected void handleData(ChannelHandlerContext channelHandlerContext, String string)
    {
        EnvDBService envDBService = applicationContext.getBean(EnvDBService.class);
        EnvData envData = new EnvData();
        envData.setSerialNo(string);
        logger.debug("######" + channelHandlerContext.channel().remoteAddress() + string + ":" + envDBService.save(envData));
    }
}