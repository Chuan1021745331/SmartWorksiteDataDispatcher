package com.hxjd.web;

import com.hxjd.service.authentication.AuthEvent;
import com.hxjd.service.environment.EnvEvent;
import com.hxjd.utils.EventBusUtil;
import org.springframework.stereotype.Controller;
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
    /**
     * 这个接口几乎不会使用，待删除
     * @param authData 占位
     */
    @RequestMapping("/auth")
    public void auth(String authData)
    {
        EventBusUtil.getInstance().post(new AuthEvent());
    }

    @RequestMapping("/env")
    public void env(String envData)
    {
        EventBusUtil.getInstance().post(new EnvEvent(envData ));
    }

    @RequestMapping("/elev")
    public void elev(String envData)
    {
        EventBusUtil.getInstance().post(new EnvEvent(envData));
    }

    @RequestMapping("/monitor")
    public void monitor(String envData)
    {
        EventBusUtil.getInstance().post(new EnvEvent(envData));
    }
}
