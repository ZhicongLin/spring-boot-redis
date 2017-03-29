package com.example.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by zc.lin on 2017/3/28.
 */
@Service
public class StringService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设值
     * @param key key
     * @param val value
     */
    public void set(String key, String val) {
        this.stringRedisTemplate.opsForValue().set(key, val);
    }

    /**
     * 取值
     * @param key key
     * @return value
     */
    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除
     * @param keys key数组
     */
    public void del(String... keys) {
        this.stringRedisTemplate.delete(Arrays.asList(keys));
    }
}
