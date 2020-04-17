package com.tanyu.simplemall.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MDUtils {
    public static final String salt = "1a2b3c4d";

    public static String md5(String s) {
        return DigestUtils.md5Hex(s);
    }

    public static String inputPass2FormPass(String pass) {
        String str =  "" + salt.charAt(0) + salt.charAt(2) + pass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPass2DBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0)
                +  salt.charAt(2)
                + formPass
                + salt.charAt(5)
                + salt.charAt(4);
        return md5(str);
    }
}
