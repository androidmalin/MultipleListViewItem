package com.malin.listview;

import java.util.ArrayList;

/**
 * Created by malin on 16-5-10.
 */
public class DataFactory {

    private DataFactory(){};

    public static ArrayList<Bean> getData() {
        ArrayList<Bean> list = new ArrayList<Bean>();
        Bean bean = null;
        for (int i = 0; i < 50; i++) {
            bean = new Bean();
            bean.id = i;
            bean.type = i % 2;
            bean.name = new StringBuffer("name:").append(i).toString();
            list.add(i, bean);
        }
        return list;
    }
}
