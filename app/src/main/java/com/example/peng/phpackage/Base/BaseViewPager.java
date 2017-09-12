package com.example.peng.phpackage.Base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by MIAO on 12/09/2017.
 */

public class BaseViewPager extends ViewPager {
    public  boolean isCanScroll;
    public BaseViewPager(Context context) {
        super(context);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!isCanScroll){
            return false;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!isCanScroll){
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
