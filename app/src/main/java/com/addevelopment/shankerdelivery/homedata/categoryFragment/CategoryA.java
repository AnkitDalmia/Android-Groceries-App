package com.addevelopment.shankerdelivery.homedata.categoryFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.addevelopment.shankerdelivery.R;
import com.addevelopment.shankerdelivery.adapters.ProductAdapter;
import com.addevelopment.shankerdelivery.model.ProductsInfoModel;

import java.util.ArrayList;
import java.util.List;


public class CategoryA extends Fragment {

    List<ProductsInfoModel> allProductList = new ArrayList<>();

    public CategoryA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category_a, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.a_recylrView);
        addAllProductList();
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(new ProductAdapter(allProductList,getActivity()));


        return view;
    }

    private void addAllProductList() {
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body og",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "40",
                "50",
                "Best Wheat rusk for Best Body of mijf",
                "1Kg",
                "20",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.aarshivaad_aata,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
        allProductList.add(new ProductsInfoModel(
                R.drawable.kissan_katchup,
                "450",
                "500",
                "Best Aarshivad Wheat for Best Body",
                "1Kg",
                "10",
                "Hello"
        ));
    }
}