package com.example.imageslider;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "ViewPagerAdapter";
    private ArrayList<ImageFragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        titles.add("first");
        titles.add("second");
        titles.add("third");
        titles.add("forth");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    void setFragments(ArrayList<ImageFragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
        Log.d(TAG, "setFragments: exited");
    }
}
