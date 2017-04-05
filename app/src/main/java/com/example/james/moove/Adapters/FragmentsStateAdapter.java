package com.example.james.moove.Adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FragmentsStateAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;
    public FragmentsStateAdapter(FragmentManager fm, ArrayList<Fragment> fragments,ArrayList<String> titles) {
        super(fm);
        this.mFragments=fragments;
        this.mTitles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
