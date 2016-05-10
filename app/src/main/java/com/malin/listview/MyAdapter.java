package com.malin.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 比原来的多了getItemViewType和getViewTypeCount这两个方法，
 */
public class MyAdapter extends BaseAdapter {

    public static final String TAG = "MyAdapter";


    public static final int VALUE_TIME_ONE = 0;// 2种不同的布局
    public static final int VALUE_LEFT_TWO = 1;
    private static final int ITEM_COUNTS = 2;

    private LayoutInflater mInflater;

    private List<Bean> myList;

    public MyAdapter(Context context, ArrayList<Bean> list) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.myList = list;
    }

    public MyAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<Bean> bean) {
        if (myList == null) {
            myList = new ArrayList<Bean>();
        }

        myList.clear();
        myList.addAll(bean);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myList != null ? myList.size() : 0;
    }

    @Override
    public Bean getItem(int position) {
        return (myList != null && position < myList.size()) ? myList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Bean bean = getItem(position);
        int type = getItemViewType(position);
        ViewHolderOne holderOne = null;
        ViewHolderTwo holderTwo = null;


        if (convertView == null) {
            switch (type) {
                case VALUE_TIME_ONE: {
                    holderOne = new ViewHolderOne();
                    convertView = mInflater.inflate(R.layout.item_one, null);
                    holderOne.tvOne = (TextView) convertView.findViewById(R.id.tv_one_item);
                    convertView.setTag(holderOne);
                    Log.d("baseAdapter", "convertView == null 类型1 position:" + position + " " + convertView.toString());
                    break;
                }

                case VALUE_LEFT_TWO: {
                    holderTwo = new ViewHolderTwo();
                    convertView = mInflater.inflate(R.layout.item_two, null);
                    holderTwo.tvTwo = (TextView) convertView.findViewById(R.id.tv_two_item);
                    convertView.setTag(holderTwo);
                    Log.d("baseAdapter", "convertView == null 类型2 position:" + position + " " + convertView.toString());
                    break;
                }


                default: {


                    break;
                }


            }

        } else {
            // Log.d("baseAdapter", "position:" + position +" "+ convertView.toString());
            switch (type) {
                case VALUE_TIME_ONE: {
                    holderOne = (ViewHolderOne) convertView.getTag();
                    Log.d("baseAdapter", "convertView != null 类型1 position:" + position + " " + convertView.toString());
                    break;
                }

                case VALUE_LEFT_TWO: {
                    holderTwo = (ViewHolderTwo) convertView.getTag();
                    Log.d("baseAdapter", "convertView != null 类型2 position:" + position + " " + convertView.toString());
                    break;
                }
                default: {
                    break;
                }

            }
        }


        switch (type) {
            case VALUE_TIME_ONE: {
                holderOne.tvOne.setText(bean.name + convertView.toString());
                break;
            }

            case VALUE_LEFT_TWO: {
                holderTwo.tvTwo.setText(bean.name+convertView.toString());
                break;
            }
            default: {
                break;
            }

        }
        return convertView;
    }

    /**
     * 根据数据源的position返回需要显示的的layout的type
     * type的值必须从0开始
     * getItemViewType方法告诉ListView每行该显示哪种item，
     * 并且该方法中返回的type类型必须为整数且不能大于getViewTypeCount返回的数。
     */
    @Override
    public int getItemViewType(int position) {
        Bean bean = getItem(position);
        int type = bean.type;
        //Log.d(TAG, "" + type);
        return type;
    }

    /**
     * 该方法返回多少个不同的布局
     */
    @Override
    public int getViewTypeCount() {
        return ITEM_COUNTS;
    }

    public static class ViewHolderOne {
        public TextView tvOne;// 左边的文字
    }


    public static class ViewHolderTwo {
        public TextView tvTwo;// 右边的文字
    }

/**
 //第一屏幕只能显示4个（0,1,2,3）
 convertView == null 类型1 position:0 android.widget.LinearLayout{1128e8f V.E...... ......ID 0,0-0,0}
 convertView == null 类型2 position:1 android.widget.LinearLayout{2b89525 V.E...... ......ID 0,0-0,0}
 convertView == null 类型1 position:2 android.widget.LinearLayout{cc543dd V.E...... ......ID 0,0-0,0}
 convertView == null 类型2 position:3 android.widget.LinearLayout{771de23 V.E...... ......ID 0,0-0,0}
 convertView == null 类型1 position:0 android.widget.LinearLayout{482ee9b V.E...... ......ID 0,0-0,0}
 convertView == null 类型2 position:1 android.widget.LinearLayout{7550238 V.E...... ......ID 0,0-0,0}

 //开始滚动
 convertView != null 类型1 position:4 android.widget.LinearLayout{482ee9b V.E...... ......ID 0,0-0,0}
 convertView != null 类型2 position:5 android.widget.LinearLayout{7550238 V.E...... ......ID 0,0-0,0}

 convertView != null 类型1 position:6 android.widget.LinearLayout{1128e8f V.E...... ........ 0,-268-1440,35}
 convertView != null 类型2 position:7 android.widget.LinearLayout{2b89525 V.E...... ........ 0,-793-1440,0}
 convertView != null 类型1 position:8 android.widget.LinearLayout{cc543dd V.E...... ........ 0,-282-1440,21}
 convertView != null 类型2 position:9 android.widget.LinearLayout{771de23 V.E...... ........ 0,-768-1440,25}
 convertView != null 类型1 position:10 android.widget.LinearLayout{482ee9b V.E...... ........ 0,-294-1440,9}
 convertView != null 类型2 position:11 android.widget.LinearLayout{7550238 V.E...... ........ 0,-786-1440,7}

 convertView != null 类型1 position:12 android.widget.LinearLayout{1128e8f V.E...... ........ 0,-292-1440,11}
 convertView != null 类型2 position:13 android.widget.LinearLayout{2b89525 V.E...... ........ 0,-783-1440,10}
 convertView != null 类型1 position:14 android.widget.LinearLayout{cc543dd V.E...... ........ 0,-299-1440,4}
 convertView != null 类型2 position:15 android.widget.LinearLayout{771de23 V.E...... ........ 0,-783-1440,10}
 convertView != null 类型1 position:16 android.widget.LinearLayout{482ee9b V.E...... ........ 0,-303-1440,0}
 convertView != null 类型2 position:17 android.widget.LinearLayout{7550238 V.E...... ........ 0,-779-1440,14}
 */
}
