package commontest;

import com.hxjd.utils.http.SmartHttp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Time: 9:12
 * Date: 2017/9/20
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class HttpTest
{
    @Test
    public void testSmartHttp()
    {
        Headers headers = new Headers.Builder()
                .add("keyId", "keyIdValue")//授权id
                .add("ts", "tsValue")//时间戳
                .add("rcode", "rcodeValue")//随机字符串
                .add("signature", "signatureValue")//密钥签名
                .build();


        SmartHttp.post("http://www.baidu.com")
//                .headers("a", "aa")
//                .headers("b", "bb")
//                .headers(headers)
//                .params("c", "cc")
//                .json("json")
//                .params("d", "dd")
                .execute(new Callback()
                {
                    @Override
                    public void onFailure(Call call, IOException e)
                    {
                        System.out.println(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException
                    {
                        System.out.println(response.body().string());
                    }
                });
    }

    public static void main(String[] args)
    {
        SmartHttp.post("http://www.baidu.com/")
                //                .headers("a", "aa")
                //                .headers("b", "bb")
                //                .headers(headers)
                //                .params("c", "cc")
//                                .json("json")
                                .params("d", "dd")
                .execute(new Callback()
                {
                    @Override
                    public void onFailure(Call call, IOException e)
                    {
                        System.out.println(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException
                    {
                        System.out.println(response.body().string());
                    }
                });
    }
}
