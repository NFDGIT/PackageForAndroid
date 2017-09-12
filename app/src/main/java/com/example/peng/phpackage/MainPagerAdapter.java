package com.example.peng.phpackage;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by MIAO on 2017/8/23.
 */

public class MainPagerAdapter extends PagerAdapter {
    private  ArrayList<View> viewList;
    public  MainPagerAdapter(){}
    public  MainPagerAdapter(ArrayList<View> viewList){
        this.viewList = viewList;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
//        super.destroyItem(container, position, object);
    }




}
