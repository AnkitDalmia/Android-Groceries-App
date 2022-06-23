package com.addevelopment.shankerdelivery.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.addevelopment.shankerdelivery.MainActivity;
import com.addevelopment.shankerdelivery.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    /*public static final String FILE_NAME = "MyFiles" ;
    public static final String LOGIN_STATUS = "login_status" ;

    ImageView watchBG,watch,insta_btn,google_btn,face_btn;
    LinearLayout button_layout;
    Button login_btn,register_btn;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //checkUserLoginStatus();
        setContentView(R.layout.activity_login);

    }

   /* private void checkUserLoginStatus() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }*/

   /*private void inti() {
        watchBG = findViewById(R.id.watchBG);
        watch = findViewById(R.id.watch);
        insta_btn = findViewById(R.id.insta_btn);
        google_btn = findViewById(R.id.google_btn);
        face_btn = findViewById(R.id.facebook_btn);
        login_btn = findViewById(R.id.login_btn);
        register_btn = findViewById(R.id.register_btn);
        button_layout = findViewById(R.id.buttons_layout);

    }*/

    public void openLogin(View view) {
        Intent i = new Intent(this,LoginPage.class);
        startActivity(i);
        finish();
    }

    public void openRegister(View view) {
        Intent i = new Intent(this,RegisterPage.class);
        startActivity(i);
        finish();
    }
}