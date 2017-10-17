package com.example.byc.testdesignlibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byc on 2017/10/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private String[] mTitles;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        if (fragments == null) {
            fragments = new ArrayList<>();
        }
        mFragmentList = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return isEmpty() ? null : mFragmentList.get(position);
    }

    private boolean isEmpty() {
        return mFragmentList == null;
    }

    @Override
    public int getCount() {
        return isEmpty() ? 0 : mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
