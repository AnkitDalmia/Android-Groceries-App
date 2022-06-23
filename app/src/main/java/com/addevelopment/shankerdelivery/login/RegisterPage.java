package com.addevelopment.shankerdelivery.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.addevelopment.shankerdelivery.R;
import com.addevelopment.shankerdelivery.customLodings.LoadingAlertDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText usernameTextBox,emailTextBox,passwordTextBox;
    CheckBox termCheckBox;
    TextView tvTerms,tvAlreadyAccount,signupBack;
    Button signupRegisterButton;
    ImageView signupFacebook,signupGoogle;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    LoadingAlertDialog loadingAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        initializeComponents();
        firebaseComponentsIntilize();

        loadingAlertDialog = new LoadingAlertDialog(RegisterPage.this);
        signupRegisterButton.setOnClickListener(this);
        signupBack.setOnClickListener(this);
        signupFacebook.setOnClickListener(this);
        signupGoogle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == signupRegisterButton.getId()){

            registrationProcess();

        }
        else if(v.getId() == signupBack.getId()){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
        else if(v.getId() == signupFacebook.getId()){
            Toast.makeText(this, "SignUp With FaceBook", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == signupGoogle.getId()){
            Toast.makeText(this, "SignUp With Google", Toast.LENGTH_SHORT).show();
        }
    }

    private void registrationProcess() {
        String email = emailTextBox.getText().toString();
        String password = passwordTextBox.getText().toString();
        if(email.isEmpty()){
            emailTextBox.setError("Please Give Email");
        }
        else if(password.isEmpty()){
            passwordTextBox.setError("please enter your Password");
        }
        else if(!email.isEmpty() && !password.isEmpty()){
            loadingAlertDialog.startLoadingDialog();
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    loadingAlertDialog.dismissDialog();
                                    Toast.makeText(RegisterPage.this, "Please Verify Your Email", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterPage.this,LoginPage.class));
                                    finish();
                                }
                                else{
                                    loadingAlertDialog.dismissDialog();
                                    Toast.makeText(RegisterPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    else{
                        loadingAlertDialog.dismissDialog();
                        Toast.makeText(RegisterPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void firebaseComponentsIntilize() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }

    private void initializeComponents() {
        usernameTextBox = findViewById(R.id.username_text_box);
        emailTextBox = findViewById(R.id.email_text_box);
        passwordTextBox = findViewById(R.id.password_text_box);

        termCheckBox = findViewById(R.id.terms_checkbox);

        tvTerms = findViewById(R.id.tv_terms);
        tvAlreadyAccount = findViewById(R.id.tv_already_account);
        signupBack = findViewById(R.id.signup_back);

        signupRegisterButton = findViewById(R.id.signup_register_btn);

        signupFacebook = findViewById(R.id.signup_facebook);
        signupGoogle = findViewById(R.id.signup_google);
    }


}