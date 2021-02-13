package com.example.register;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public MyFragmentPagerAdapter(FragmentManager manager){
        super(manager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments==null?null:fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    public void addFragment(Fragment fragment){
        fragments.add(fragment);
        notifyDataSetChanged();
    }
}
