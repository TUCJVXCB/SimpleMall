package com.tanyu.simplemall.utils;

import com.alibaba.fastjson.JSON;

public class Object2String {
    public static <T> String convert(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == Integer.class) {
            return String.valueOf(clazz);
        }else if (clazz == String.class) {
            return (String) value;
        }else if (clazz == Long.class) {
            return String.valueOf(value);
        }else {
            return JSON.toJSONString(value);
        }
    }
}
