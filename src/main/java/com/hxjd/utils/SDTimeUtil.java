package com.hxjd.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hxjd.utils.http.SmartHttp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Time: 10:20 AM
 * Date: 10/12/2017
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class SDTimeUtil
{
    public final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取国家授时中心标准时间戳
     * 同步获取
     * 从国家授时中心请求时间戳，未获取结果前将一直等待
     * @return 时间戳 单位：s
     */
    public static String getRemoteTimeStamp()
    {
        String timeStamp;

        String timeApi = "http://api.k780.com:88/?app=life.time&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";

        JSONObject object = JSON.parseObject(SmartHttp.post(timeApi).execute());

        timeStamp = object.getJSONObject("result").getString("timestamp");

        return timeStamp;
    }

    /**
     * 获取本地时间戳
     * @return 时间戳 单位：s
     */
    public static String getLocalTimeStamp()
    {
        long ts = System.currentTimeMillis() / 1000;
        return String.valueOf(ts);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
    }


    public static boolean timeCalibration()
    {
        return false;
    }
}
