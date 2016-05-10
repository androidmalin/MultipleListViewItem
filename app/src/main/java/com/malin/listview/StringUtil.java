package com.malin.listview;

import android.text.TextUtils;

/**
 * Created by malin on 16-5-10.
 */
public class StringUtil {


    private volatile static StringUtil instance = null;

    private StringUtil(){};

    public static StringUtil getInstance() {
        if (instance == null) {
            synchronized (StringUtil.class) {
                if (instance == null) {
                    instance = new StringUtil();
                }
            }
        }

        return  instance;
    }


    public String getShortAddress(String msg){
        String result = null;
        if (!TextUtils.isEmpty(msg)){
            int start = msg.indexOf('{');
            int end = start+8;
            result =  msg.substring(start+1,end);
            return result==null?null:result;
        }else{
            return null;
        }

    }
}
