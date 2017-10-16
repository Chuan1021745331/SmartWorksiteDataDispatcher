package webtest;

import com.hxjd.Starter;
import com.hxjd.handler.web.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Time: 14:36
 * Date: 2017/9/13
 * Corp: 华夏九鼎
 * Name: Nandem(nandem@126.com)
 * ----------------------------
 * Desc: 请输入描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class)
public class Tester
{
    private MockMvc mockMvc;

    //初始化工作
    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    //测试
    @Test
    public void index() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{'test':'ok'}"));

        System.out.println("ok");
    }
}
