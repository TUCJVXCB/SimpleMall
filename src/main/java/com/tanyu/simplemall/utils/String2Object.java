package com.tanyu.simplemall.utils;

import com.alibaba.fastjson.JSON;

public class String2Object<T> {

    public static <T> T convert(String str, Class<T> clazz) {
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        }else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        }else if (clazz == String.class) {
            return (T) str;
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }
}
