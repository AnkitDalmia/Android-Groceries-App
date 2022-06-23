package com.addevelopment.shankerdelivery.homedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.addevelopment.shankerdelivery.R;
import com.addevelopment.shankerdelivery.adapters.ProductAdapter;

import java.util.ArrayList;

import static com.addevelopment.shankerdelivery.MainActivity.addToFavorite;


public class FavoritsFragments extends Fragment {

    View view;
    RecyclerView fragmentFavoriteRecyclerView;
    TextView fragmentFavoriteShowEmpty;
    ImageView fragmentFavoriteEmptyImg;
    TextView fragmentFavoriteSorting;

    public FavoritsFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_favorits_fragments, container, false);
        fragmentFavoriteRecyclerView = view.findViewById(R.id.fragment_favorite_recyclerView);
        fragmentFavoriteShowEmpty = view.findViewById(R.id.fragment_favorite_show_empty);
        fragmentFavoriteEmptyImg = view.findViewById(R.id.fragment_favorite_empty_img);
        fragmentFavoriteSorting = view.findViewById(R.id.fragment_favorite_sorting);

        fragmentFavoriteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ProductAdapter productAdapter = new ProductAdapter(new ArrayList<>(addToFavorite),getActivity());
        fragmentFavoriteRecyclerView.setAdapter(productAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(addToFavorite.size() != 0){
            fragmentFavoriteEmptyImg.setVisibility(view.INVISIBLE);
            fragmentFavoriteShowEmpty.setVisibility(view.INVISIBLE);
        }
        else{
            fragmentFavoriteEmptyImg.setVisibility(view.VISIBLE);
            fragmentFavoriteShowEmpty.setVisibility(view.VISIBLE);
        }

    }
}