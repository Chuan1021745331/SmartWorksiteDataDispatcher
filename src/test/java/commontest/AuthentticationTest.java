package commontest;

import com.hxjd.service.authentication.AuthenticationDispatcher;
import com.hxjd.utils.AuthenticationUtil;
import org.junit.Test;

/**
 * Time: 9:37
 * Date: 2017/9/14
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class AuthentticationTest
{
    @Test
    public void testRandomString()
    {
//        System.out.println(AuthenticationUtil.getRandowmString());
    }

    @Test
    public void testTs()
    {
//        System.out.println(AuthenticationUtil.getTimeStamp());
    }

    @Test
    public void testSha1()
    {
//        System.out.println(AuthenticationUtil.sha1("nandem"));
    }

    @Test
    public void testDispatch()
    {
        //这里测试时不会等待异步任务返回结果，整个调用过程就会结束，需要在正常启动的程序中使用
//        AuthenticationDispatcher dispatcher = new AuthenticationDispatcher();
//        dispatcher.dispatch();
    }

    public static void main(String[] args)
    {
//        AuthenticationDispatcher dispatcher = new AuthenticationDispatcher();
//        dispatcher.dispatch();
    }
}
