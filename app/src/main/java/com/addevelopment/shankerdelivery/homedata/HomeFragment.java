package com.addevelopment.shankerdelivery.homedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.addevelopment.shankerdelivery.R;
import com.addevelopment.shankerdelivery.adapters.ProductAdapter;
import com.addevelopment.shankerdelivery.viewPagerAdapter.FoodCategoryAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;

    View view;
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    ViewPager productCategoryViewpager;
    TabLayout homeCategoryTab;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_home, container, false);


        productCategoryViewpager = view.findViewById(R.id.product_category_viewpager);
        homeCategoryTab = view.findViewById(R.id.home_category_tab);

        FragmentManager fragmentManager = getChildFragmentManager();
        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(fragmentManager);

        productCategoryViewpager.setAdapter(foodCategoryAdapter);
        homeCategoryTab.setupWithViewPager(productCategoryViewpager);

        return view;
    }


}