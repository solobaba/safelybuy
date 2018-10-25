package com.nuturetech.safelybuy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nuturetech.safelybuy.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity {
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void goToLogin(){
        startActivity(new Intent(LoginActivity.this, NavigationActivity.class));
        finish();
    }

    @OnClick(R.id.sign_up_here)
    public void goToSignUp(){
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        finish();
    }

    @OnClick(R.id.forgot_password)
    public void goToForgot(){
        startActivity(new Intent(LoginActivity.this, PasswordRecoveryActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
