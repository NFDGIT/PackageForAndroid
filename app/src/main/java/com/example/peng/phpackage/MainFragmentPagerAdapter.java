package com.example.peng.phpackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by MIAO on 2017/9/5.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragList;
    public MainFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragList) {
        super(fm);
        this.fragList = fragList;
    }
    @Override
    public int getCount() {
        return fragList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }
}
