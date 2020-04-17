package com.tanyu.simplemall.redis.key;

public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}
