package com.bolink.util;

public class CheckUtil {
    public static boolean isLong(String object){
        boolean a = false;
        try {
            Long.valueOf(object);
            a=true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return a;
    }
}
