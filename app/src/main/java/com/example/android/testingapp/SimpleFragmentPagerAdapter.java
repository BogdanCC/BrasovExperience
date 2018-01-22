package com.example.android.testingapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bogda on 1/17/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    /** Context of the app */
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OutdoorFragment();
            case 1:
                return new HistoricFragment();
            case 2:
                return new EntertainmentFragment();
            default:
                return null;
        }
    }

}
