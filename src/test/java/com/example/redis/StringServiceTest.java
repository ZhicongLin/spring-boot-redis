package com.example.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by zc.lin on 2017/3/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StringServiceTest {

    @Resource
    private StringService stringService;

    @Test
    public void set() throws Exception {
        this.stringService.set("strKey", "strValue");
        this.stringService.set("strKey1", "strValue1");
    }

    @Test
    public void get() throws Exception {
        this.stringService.set("strKey", "strValue");
        this.stringService.set("strKey1", "strValue1");
        String value = this.stringService.get("strKey");
        String value1 = this.stringService.get("strKey1");
        Assert.assertTrue("strValue".equals(value));
        Assert.assertTrue("strValue1".equals(value1));
        this.stringService.del("strKey1");
        Assert.assertNull(this.stringService.get("strKey1"));
    }

    @Test
    public void del() throws Exception {
        this.stringService.del("strKey", "strKey1");
    }

}