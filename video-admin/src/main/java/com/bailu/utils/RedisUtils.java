package com.bailu.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * redis 工具类
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;
    @Autowired
    private ListOperations<String, Object> listOperations;
    @Autowired
    private SetOperations<String, Object> setOperations;
    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    public RedisTemplate<String, Object> getRedisTemplate(){
        return redisTemplate;
    }
    public ValueOperations<String, String> getValueOperations(){
        return valueOperations;
    }
    public HashOperations<String, String, Object> getHashOperations(){
        return hashOperations;
    }
    public ListOperations<String, Object> getListOperations(){
        return listOperations;
    }
    public SetOperations<String, Object> getSetOperations(){
        return setOperations;
    }
    public ZSetOperations<String, Object> getzSetOperations(){
        return zSetOperations;
    }
    /**  默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1;
    private final static Gson gson = new Gson();

    public void set(String key, Object value, long expire){
        valueOperations.set(key, toJson(value));
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void hset(String key, String hashKey, Object value){
        hashOperations.put(key,hashKey,value);
    }

    public Object hget(String key, String hashKey){
        return hashOperations.get(key,hashKey);
    }

    public String hGetStr(String key, String hashKey){
        Object obj = hashOperations.get(key,hashKey);
        if(obj == null)
            return null;
        return obj.toString();
    }

    public Map<String, Object> hEntries(String key){
        return hashOperations.entries(key);
    }

    public void hdel(String key, String hashKey){
        hashOperations.delete(key, hashKey);
    }

    public void lpush(String key, Object obj) { listOperations.leftPush(key,obj.toString());}

    public void lpushAll(String key, Object... values) { listOperations.leftPushAll(key,values);}

    public List<Object> lrange(String key, long start, long end){ return listOperations.range(key, start, end); }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object){
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return gson.toJson(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json, clazz);
    }
}
