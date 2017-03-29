package com.example.redis;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zc.lin on 2017/3/27.
 */
@Service
public class ValueService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Serializable value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> clazz) {
        return (T) this.redisTemplate.opsForValue().get(key);
    }

    public void delete(String... keys) {
        if (null == keys) {
            return;
        }
        if (keys.length == 1) {
            this.redisTemplate.delete(keys[0]);
        } else {
            this.redisTemplate.delete(Arrays.asList(keys));
        }
    }


}
