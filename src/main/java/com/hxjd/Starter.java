package com.hxjd;

import com.hxjd.listener.MyApplicationFailedEvent;
import com.hxjd.listener.MyApplicationReadyEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Time: 20:45
 * Date: 2017/9/12
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 数据转发服务启动类
 */
@SpringBootApplication
@MapperScan("com.hxjd.dao")
public class Starter
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication application = new SpringApplication(Starter.class);

        application.addListeners(new MyApplicationReadyEvent(), new MyApplicationFailedEvent());

        application.run(args);
    }
}
