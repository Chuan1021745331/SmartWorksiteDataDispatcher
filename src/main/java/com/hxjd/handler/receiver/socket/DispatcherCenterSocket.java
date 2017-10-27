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
//        envData.setRecordTime("hhhhhh");
//        envData.setHumidity("a");
        logger.debug(envDBService.save(envData) + "");
    }

    @Override
    protected void handleData(ChannelHandlerContext channelHandlerContext, String string)
    {
        EnvDBService envDBService = applicationContext.getBean(EnvDBService.class);
        EnvData envData = new EnvData();
        envData.setSerialNo(string);
//        envData.setTemperature();
//        envData.setHumidity();
//        envData.setNoise();
//        envData.setPm2p5();
//        envData.setPm10();
//        envData.setWindSpeed();
//        envData.setWindDirection();
        //#env#deviceId#deviceCode#temperature#humidity#pm2p5#pm10#noise#windSpeed#windDirection#
        if(string.startsWith("#env#"))
        {
            System.out.println(string);
            String[] envDataArr = string.split("#");
            envData.setDeviceId(envDataArr[2]);
            envData.setDeviceCode(envDataArr[3]);
            envData.setTemperature(envDataArr[4]);
            envData.setHumidity(envDataArr[5]);
            envData.setPm2p5(envDataArr[6]);
            envData.setPm10(envDataArr[7]);
            envData.setNoise(envDataArr[8]);
            envData.setWindSpeed(envDataArr[9]);
            envData.setWindDirection(envDataArr[10]);
        }
        logger.debug("您发送的数据为：" +
                "\r\n　deviceId：" + envData.getDeviceId() +
                "\r\n　deviceCode：" + envData.getDeviceCode() +
                "\r\n　temperature：" + envData.getTemperature() +
                "\r\n　humidity：" + envData.getHumidity() +
                "\r\n　pm2p5：" + envData.getPm2p5() +
                "\r\n　pm10：" + envData.getPm10() +
                "\r\n　noise：" + envData.getNoise() +
                "\r\n　windSpeed：" + envData.getWindSpeed() +
                "\r\n　windDirection：" + envData.getWindDirection());
    }

    public static void main(String[] args)
    {
        String t = "#env#deviceId#deviceCode#temperature#humidity#pm2p5#pm10#noise#windSpeed#windDirection#";
        String[] tarr = t.split("#");
        System.out.println(tarr[1]);
        System.out.println(tarr[2]);
        System.out.println(tarr[3]);
    }
}