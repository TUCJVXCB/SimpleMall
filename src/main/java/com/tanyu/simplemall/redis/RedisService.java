package com.tanyu.simplemall.redis;

import com.tanyu.simplemall.redis.key.KeyPrefix;
import com.tanyu.simplemall.utils.Object2String;
import com.tanyu.simplemall.utils.String2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    private JedisPool pool;

    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String s = jedis.get(prefix.getPrefix() + key);
            T t = String2Object.convert(s, clazz);
            return t;
        }finally {
            return2Pool(jedis);
        }
    }

    public <T> Boolean set(KeyPrefix keyPrefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String str = Object2String.convert(value);
            if (str == null || str.length() == 0) {
                return false;
            }

            String realKey = keyPrefix.getPrefix() + key;
            int seconds = keyPrefix.expireSeconds();

            if (seconds <= 0) {
                jedis.set(realKey, str);
            }else {
                jedis.setex(realKey, seconds, str);
            }
            return true;
        }finally {
            return2Pool(jedis);
        }
    }


    private void return2Pool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
