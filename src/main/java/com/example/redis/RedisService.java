package com.example.redis;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zc.lin on 2017/3/27.
 */
@Service
public class RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    void set(String key, Serializable value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    void setListValue(String key, Serializable value) {
        this.redisTemplate.opsForList().rightPush(key, value);
    }

    <T extends Object> List<T> getList(String key, Class<T> clazz) {
        ListOperations<String, ?> lops = this.redisTemplate.opsForList();
        return (List<T>) lops.range(key, 0L, lops.size(key));
    }

    String getStringValue(String key) {
        final Object value = this.redisTemplate.opsForValue().get(key);
        return value != null ? String.valueOf(value) : null;

    }

    @SuppressWarnings("unchecked")
    <T> T get(String key, Class<T> clazz) {
        return (T) this.redisTemplate.opsForValue().get(key);
    }

    void delete(String... keys) {
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
