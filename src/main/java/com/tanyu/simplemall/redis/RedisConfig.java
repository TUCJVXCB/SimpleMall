package com.tanyu.simplemall.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.timeout}")
    private Integer timeout;

    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer poolMaxActive;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer poolMaxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private Integer poolMaxWait;
}
