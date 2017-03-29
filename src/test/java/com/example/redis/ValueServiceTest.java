package com.example.redis;

import com.example.base.SetObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by zc.lin on 2017/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueServiceTest {
    @Resource
    private ValueService valueService;

    @Test
    public void set() throws Exception {
        this.valueService.set("key", "value");
        this.valueService.set("key", 1);
        this.valueService.set("key", '1');
        this.valueService.set("key", new SetObject());
    }

    @Test
    public void get() throws Exception {
        this.valueService.set("okey", new SetObject());
        final Object value = this.valueService.get("okey", Object.class);
        final Object value1 = this.valueService.get("key1", Object.class);
        Assert.assertNotNull(value);
        Assert.assertNull(value1);
    }

    @Test
    public void delete() throws Exception {
        this.valueService.delete("key");
        this.valueService.delete("okey");
        this.valueService.delete("key", "okey");
    }

}