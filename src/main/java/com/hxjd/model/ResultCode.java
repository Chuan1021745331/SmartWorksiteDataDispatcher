package com.hxjd.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Time: 14:09
 * Date: 2017/9/19
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public enum ResultCode
{
    Normal(0, "正常"),
    ParamOrContentError(1, "参数格式或内容错误"),
    PermissionDenied(2, "无操作权限"),
    SystemError(3, "系统异常"),
    OtherError(4, "其他错误");

    private int code;
    private String message;

    ResultCode(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public int getCode()
    {
        return this.code;
    }

    /**
     * 通过code判定是否相等
     *
     * @param code code
     * @return 相等返回true，否则返回false;
     */
    public boolean isEquals(int code)
    {
        return this.code == code;
    }

    public static String getMessageByCode(int code)
    {
        ResultCode[] resultCodes = values();
        String returnValue;
        try
        {
            returnValue = resultCodes[code].message;
        }
        catch(Exception e)
        {
            returnValue = "未定义操作码";
        }
        return returnValue;
    }
}
