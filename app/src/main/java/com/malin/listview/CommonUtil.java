package com.malin.listview;

import java.lang.reflect.Field;

/**
 * link
 * http://www.oschina.net/code/snippet_229588_21500
 */
public class CommonUtil {


    public static String toString(Object obj) {

        if (obj == null)
            return "null";

        StringBuffer sb = new StringBuffer();

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        sb.append(clazz.getName() + "{");
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                sb.append("\n  ")
                        .append(field.getName())
                        .append(":")
                        .append(field.get(obj));

            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        sb.append("\n}");
        return sb.toString();
    }

}