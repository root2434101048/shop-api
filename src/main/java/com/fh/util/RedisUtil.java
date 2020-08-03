package com.fh.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    //删除
    public static void del(String key){
        Jedis jedis =null;
        try {
            jedis = RedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
    }

    //设置
    public static void set(String key,String value){
        Jedis jedis =null;
        try {
            jedis = RedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
    }

    //获取
    public static String get(String key){
        Jedis jedis =null;
        try {
            jedis = RedisPool.getResource();
            String res = jedis.get(key);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
    }
}
