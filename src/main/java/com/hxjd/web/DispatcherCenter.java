package com.hxjd.web;

import com.hxjd.model.EnvData;
import com.hxjd.service.authentication.AuthEvent;
import com.hxjd.service.environment.EnvEvent;
import com.hxjd.utils.EventBusUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/data")
public class DispatcherCenter
{
    private final static Logger logger = LoggerFactory.getLogger(DispatcherCenter.class);
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
     * @param dataBean 环境数据
     */
    @RequestMapping("/env")
    public void env(EnvData dataBean)
    {
        EventBusUtil.getInstance().post(new EnvEvent(dataBean));
    }

    /**
     * 接收升降机数据
     * @param elevData 升降机数据
     */
    @RequestMapping("/elev")
    public void elev(String elevData)
    {
        EventBusUtil.getInstance().post(1);
    }

    /**
     * 接收视频监控数据
     * @param moniData 视频监控数据
     */
    @RequestMapping("/monitor")
    public void monitor(String moniData)
    {
        EventBusUtil.getInstance().post(1);
    }

    /*^_^------下面为平安卡数据------^_^*/
//    public void
}
