package com.example.redis;

import com.example.base.SetObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zc.lin on 2017/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {
    @Resource
    private RedisService redisService;

    @Test
    public void set() throws Exception {
        this.redisService.set("key", "value");
        this.redisService.set("key", 1);
        this.redisService.set("key", '1');
        this.redisService.set("key", new SetObject());
    }

    @Test
    public void getStringValue() throws Exception {
        this.redisService.set("key", "value");
        final String value = this.redisService.getStringValue("key");
        final String value1 = this.redisService.getStringValue("key1");
        Assert.assertTrue("value".equals(value));
        Assert.assertNull(value1);
    }

    @Test
    public void get() throws Exception {
        this.redisService.set("okey", new SetObject());
        final Object value = this.redisService.get("okey", Object.class);
        final Object value1 = this.redisService.get("key1", Object.class);
        Assert.assertNotNull(value);
        Assert.assertNull(value1);
    }

    @Before
    public void setListValue() throws Exception {
        this.redisService.setListValue("lk", "1");
        this.redisService.setListValue("lk", "2");
        this.redisService.setListValue("lk", "3");
        this.redisService.setListValue("lk", "4");
        this.redisService.setListValue("lk1", "1");
    }

    @Test
    public void getList() throws Exception {
        final List<String> ls = this.redisService.getList("lk", String.class);
        final List<String> ls1 = this.redisService.getList("lk1", String.class);
        System.out.println(ls);
        System.out.println(ls1);
        Assert.assertTrue(ls.size() > 0);
        Assert.assertTrue(ls1.size() == 1);
        this.redisService.delete("lk", "lk1");
    }

    @Test
    public void delete() throws Exception {
        this.redisService.delete("key");
        this.redisService.delete("okey");
        this.redisService.delete("key", "okey");
    }

}