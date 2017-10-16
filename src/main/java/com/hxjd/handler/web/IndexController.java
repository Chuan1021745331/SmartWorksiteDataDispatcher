package com.hxjd.handler.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Time: 20:50
 * Date: 2017/9/12
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 首页控制器，处理页面调度
 */
@Controller
public class IndexController
{
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index()
    {
        return "/index";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test()
    {
        return "{'test':'ok'}";
    }
}