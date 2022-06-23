package com.addevelopment.shankerdelivery;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.addevelopment.shankerdelivery.adapters.ProductAdapter;
import com.addevelopment.shankerdelivery.homedata.CartFragment;
import com.addevelopment.shankerdelivery.homedata.FavoritsFragments;
import com.addevelopment.shankerdelivery.homedata.HomeFragment;
import com.addevelopment.shankerdelivery.login.LoginActivity;
import com.addevelopment.shankerdelivery.model.ProductsInfoModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.SortedSet;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    public static SortedSet<ProductsInfoModel> addToFavorite = new TreeSet<>();

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Toolbar fragHomeToolbar;
    ChipNavigationBar bottomAppBar;

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    RecyclerView recyclerView;
    ProductAdapter productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseInitializeComponent();
        initializeComponent();
        toolbarInit();

        bottomAppBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.item_home:
                        fragment = new HomeFragment();
                        fragHomeToolbar.setVisibility(View.VISIBLE);
                        break;

                    case R.id.item_like:
                        fragment = new FavoritsFragments();
                        fragHomeToolbar.setVisibility(View.INVISIBLE);
                        break;

                    case R.id.item_cart:
                        fragment = new CartFragment();
                        break;

                }
                if(fragment != null){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fregLayout,fragment).commit();
                }
            }
        });


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment home = new HomeFragment();
        fragmentTransaction.add(R.id.fregLayout, home);
        fragmentTransaction.commit();

    }

    private void toolbarInit() {

        fragHomeToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(fragHomeToolbar);

    }


    private void initializeComponent() {

        bottomAppBar = findViewById(R.id.bottom_app_bar);
        bottomAppBar.setItemSelected(R.id.item_home,true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_main_menu, menu);
        MenuItem item = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    private void firebaseInitializeComponent() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }

    public void logOut(View view) {
        firebaseAuth.signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Exit!!")
                .setMessage("You realy want to exit?")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
