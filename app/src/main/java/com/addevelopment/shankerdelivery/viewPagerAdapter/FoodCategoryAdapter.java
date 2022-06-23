package com.addevelopment.shankerdelivery.viewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.addevelopment.shankerdelivery.homedata.categoryFragment.CategoryA;
import com.addevelopment.shankerdelivery.homedata.categoryFragment.CategoryB;

public class FoodCategoryAdapter extends FragmentPagerAdapter {

    public FoodCategoryAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new CategoryA();
            case 1: return new CategoryB();
            default: return new CategoryA();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:return title = "Category A";
            case 1:return title = "Category B";
            default:return title = "Category A";
        }

    }
}
