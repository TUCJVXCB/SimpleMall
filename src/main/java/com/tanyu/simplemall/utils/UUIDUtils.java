package com.tanyu.simplemall.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
