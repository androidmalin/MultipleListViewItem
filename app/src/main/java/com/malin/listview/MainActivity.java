package com.malin.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * malin
 *
 * link:
 * http://www.jcodecraeer.com/a/anzhuokaifa/2012/0802/334.html
 * http://blog.csdn.net/lmj623565791/article/details/24333277
 * http://www.imlongluo.com/blog/?p=263
 * http://www.longdw.com/listview-category-getitemviewtype-getviewtypecount/
 * http://blog.csdn.net/guolin_blog/article/details/44996879
 * http://blog.csdn.net/lmj623565791/article/details/24333277
 */
public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv);
        mAdapter = new MyAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
        mAdapter.setData(getMessage());

    }


    private ArrayList<Bean> getMessage() {
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
