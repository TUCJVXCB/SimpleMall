package com.tanyu.simplemall.redis.key;

public class UserKey extends BasePrefix{

    public static final Integer TOKEN_EXPIRE = 3600 * 24 * 2;

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }


    public static UserKey token = new UserKey(TOKEN_EXPIRE, "token");
    public static UserKey getById = new UserKey(0, "id");
}
