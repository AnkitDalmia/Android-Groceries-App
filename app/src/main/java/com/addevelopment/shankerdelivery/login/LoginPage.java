package com.addevelopment.shankerdelivery.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.addevelopment.shankerdelivery.MainActivity;
import com.addevelopment.shankerdelivery.R;
import com.addevelopment.shankerdelivery.customLodings.LoadingAlertDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    TextView signinBack,forgetPassword,createAnAccount;
    TextInputEditText signinEmailTextBox,signinPasswordTextBox;
    Button signinButton;
    ImageView signinFaceBook,signinGoogle;
    LoadingAlertDialog loadingAlertDialog;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loadingAlertDialog = new LoadingAlertDialog(this);
        initializeComponent();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();


        signinButton.setOnClickListener(this);
        signinBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == signinButton.getId()){
            loginProcess();
        }

        else if(signinBack.getId() == v.getId()){
            startActivity(new Intent(LoginPage.this,LoginActivity.class));
            finish();
        }
    }

    private void loginProcess() {
        String email = signinEmailTextBox.getText().toString();
        String password = signinPasswordTextBox.getText().toString();

        if(email.isEmpty()){

            signinEmailTextBox.setError("Email is mandatory");
            signinEmailTextBox.requestFocus();
        }
        else if(password.isEmpty()){
            signinPasswordTextBox.setError("Password is mandatory");
            signinPasswordTextBox.requestFocus();

        }
        else if(!(email.isEmpty()) && !(password.isEmpty()) ){
            loadingAlertDialog.startLoadingDialog();
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!(task.isSuccessful())){
                        loadingAlertDialog.dismissDialog();
                        Toast.makeText(LoginPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (firebaseAuth.getCurrentUser().isEmailVerified()) {
                            Toast.makeText(LoginPage.this, "Welcome ", Toast.LENGTH_SHORT).show();
                            loadingAlertDialog.dismissDialog();
                            startActivity(new Intent(LoginPage.this, MainActivity.class));
                            finish();
                        }
                        else{
                            loadingAlertDialog.dismissDialog();
                            Toast.makeText(LoginPage.this,task.getException().getMessage(),Toast.LENGTH_SHORT);
                        }
                    }
                }
            });
        }
        else{
            Toast.makeText(LoginPage.this,"Sign in Is Field due to another region",Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeComponent() {

        signinBack = findViewById(R.id.signin_back);
        forgetPassword = findViewById(R.id.forget_password);
        createAnAccount = findViewById(R.id.create_an_account);
        signinEmailTextBox = findViewById(R.id.signin_email_text_box);
        signinPasswordTextBox = findViewById(R.id.signin_password_text_box);
        signinButton = findViewById(R.id.signin_button);
        signinFaceBook = findViewById(R.id.signin_facebook);
        signinGoogle = findViewById(R.id.signin_google);

    }

}