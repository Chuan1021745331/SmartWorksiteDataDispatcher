package com.hxjd.receiver.http;

import com.hxjd.model.*;
import com.hxjd.service.authentication.AuthEvent;
import com.hxjd.service.elevator.ElevatorDBService;
import com.hxjd.service.environment.EnvDBService;
import com.hxjd.service.monitor.MonitorDBService;
import com.hxjd.service.pinganka.PakDBService;
import com.hxjd.utils.EventBusUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Time: 11:45
 * Date: 2017/9/15
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@RestController
@RequestMapping("/dispatch")
public class DispatcherCenterHttp
{
    private final static Logger logger = LoggerFactory.getLogger(DispatcherCenterHttp.class);

    @Autowired
    private EnvDBService envDBService;
    @Autowired
    private ElevatorDBService elevatorDBService;
    @Autowired
    private PakDBService pakDBService;
    @Autowired
    private MonitorDBService monitorDBService;

    /**
     * 鉴权这个接口在我们这儿几乎不会使用，待删除
     * @param authData 占位
     */
    @RequestMapping("/auth")
    public void auth(String authData)
    {
        EventBusUtil.getInstance().post(new AuthEvent());
    }

    /**
     * 接收环境监测数据
     * @param envData 环境数据
     */
    @ResponseBody
    @RequestMapping("/env")
    public String env(EnvData envData)
    {
        EventBusUtil.getInstance().post(new EnvEvent(envData));

        envDBService.save(envData);

        return "您发送的数据为　->　 deviceId:" + envData.getDeviceId() + "　deviceCode:" + envData.getDeviceCode() + "　temperature:" + envData.getTemperature() + "　humidity:" + envData.getHumidity() + "　pm2p5:" + envData.getPm2p5() + "　pm10:" + envData.getPm10() + "　noise:" + envData.getNoise() + "　windSpeed:" + envData.getWindSpeed() + "　windDirection:" + envData.getWindDirection();
    }

    /**
     * 接收升降机数据
     * @param elevData 升降机数据
     */
    @ResponseBody
    @RequestMapping("/ele")
    public String elev(ElevatorData elevData)
    {
        EventBusUtil.getInstance().post(new ElevatorEvent(elevData));

        elevatorDBService.save(elevData);

        return "您发送的数据为　->　deviceId:" + elevData.getDeviceId() + "　deviceCode:" + elevData.getDeviceCode() + "　startTime:" + elevData.getStartTime() + "　stopTime:" + elevData.getStopTime() + "　peopleNumber:" + elevData.getPeopleNumber() + "　startHeight:" + elevData.getStartHeight() + "　stopHeight:" + elevData.getStopHeight() + "　speed:" + elevData.getSpeed() + "　load:" + elevData.getLoad() + "　direction:" + elevData.getDirection() + "　status:" + elevData.getStatus();
    }

    /**
     * 接收视频监控数据
     * @param monitorData 视频监控数据
     */
    @ResponseBody
    @RequestMapping("/mon")
    public String monitor(MonitorData monitorData)
    {
        EventBusUtil.getInstance().post(new MonitorEvent(monitorData));

        monitorDBService.save(monitorData);

        return "您发送的数据为　->　coverUrl:" + monitorData.getCoverUrl() + "　playUrl:" + monitorData.getPlayUrl() + "　camNo:" + monitorData.getCamNo() + "　status:" + monitorData.getStatus() + "　deviceCode:" + monitorData.getDeviceCode();
    }

    /*^_^------下面为平安卡数据------^_^*/
    //    public void

    /**
     * 接收门禁考勤数据
     * @param pakData 门禁数据
     */
    @ResponseBody
    @RequestMapping("/pak")
    public String pinganka(PakData pakData)
    {
        EventBusUtil.getInstance().post(new PakEvent(pakData));

        pakDBService.save(pakData);

        return "您发送的数据为　->　cardNo:" + pakData.getCardNo() + "　status:" + pakData.getStatus();
    }
}
