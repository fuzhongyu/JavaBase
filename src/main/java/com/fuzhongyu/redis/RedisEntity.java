package com.fuzhongyu.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * redis实例（不用redisPool，采用单个创建）
 * 注：这边不做过多介绍（只写个测试例子），主要还是以redis连接池为主，看RedisUtils
 *
 * Created by fuzhongyu on 2017/3/20.
 */
public class RedisEntity {

    private  Jedis jedis;

    /**
     * 连接redis服务器
     */
    public  void setup(){
        String ip="127.0.0.1";
        Integer port=6379;
        jedis=new Jedis(ip,port);
    }

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    public String get(String key) {

        String value = null;
        if (jedis.exists(key)) {
            value = jedis.get(key);
        }
        return value;
    }

    /**
     * 设置缓存
     * @param key 键
     * @param value  值
     */
    public void set(String key,String value){
        jedis.set(key,value);
    }


    @Test
    public void test(){
        setup();
        set("name","fzy");
        System.out.println(get("name"));
    }
}
