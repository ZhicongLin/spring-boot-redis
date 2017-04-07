package com.example.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zc.lin on 2017/3/28.
 */
@Service
@SuppressWarnings("unchecked")
public class ListService {


    @Resource
    private RedisTemplate redisTemplate;
    //endregion

    /**
     * 压栈
     *
     * @param key
     * @param value
     * @return
     */
    public Long leftPush(String key, String value) {
        return this.redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 出栈
     *
     * @param key
     * @return
     */
    public Object leftPop(String key) {
        return this.redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 入队
     *
     * @param key
     * @param value
     * @return
     */
    public Long rightPush(String key, String value) {
        return this.redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 出队
     *
     * @param key
     * @return
     */
    public Object rightPop(String key) {
        return this.redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 栈/队列长
     *
     * @param key
     * @return
     */
    public Long length(String key) {
        return this.redisTemplate.opsForList().size(key);
    }

    /**
     * 范围检索
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<?> range(String key, long start, long end) {
        return this.redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 移除
     *
     * @param key
     * @param i
     * @param value
     */
    public void remove(String key, long i, String value) {
        this.redisTemplate.opsForList().remove(key, i, value);
    }

    /**
     * 检索
     *
     * @param key
     * @param index
     * @return
     */
    public Object index(String key, long index) {
        return this.redisTemplate.opsForList().index(key, index);
    }

    /**
     * 置值
     *
     * @param key
     * @param index
     * @param value
     */
    public void set(String key, long index, String value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 裁剪
     *
     * @param key
     * @param start
     * @param end
     */
    public void trim(String key, long start, int end) {
        this.redisTemplate.opsForList().trim(key, start, end);
    }

    /**
     * 删除
     *
     * @param keys 缓存的key
     */
    public void del(String... keys) {
        if (keys != null) {
            this.redisTemplate.delete(Arrays.asList(keys));
        }
    }
}
