package commontest;

import com.hxjd.model.ResultCode;
import org.junit.Test;

/**
 * Time: 14:19
 * Date: 2017/9/19
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
public class EnumTest
{
    @Test
    public void testIndex()
    {
        System.out.println(ResultCode.OtherError.getMessage());
        System.out.println(ResultCode.OtherError.getCode());
        System.out.println(ResultCode.getMessageByCode(22));

        System.out.println(ResultCode.Normal.isEquals(0));
        System.out.println(ResultCode.Normal.isEquals(12));
        ResultCode rc1 = ResultCode.Normal;
        ResultCode rc2 = ResultCode.Normal;
        System.out.println(rc1 == rc2);
        System.out.println(rc1.toString());
        System.out.println(rc2.toString());
    }
}
