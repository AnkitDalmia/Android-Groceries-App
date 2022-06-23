package com.addevelopment.shankerdelivery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import com.addevelopment.shankerdelivery.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_SCREEN_TIME_OUT=2000;
    boolean login_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       // SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
       // login_status = sharedPreferences.getBoolean(LOGIN_STATUS,false);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goLoginActivity(login_status);
            }
        },SPLASH_SCREEN_TIME_OUT);



    }

    private void goLoginActivity(boolean login_staus) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser !=null){
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
        }
        finish();

    }
}