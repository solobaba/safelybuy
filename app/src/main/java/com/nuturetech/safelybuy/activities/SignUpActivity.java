package com.nuturetech.safelybuy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nuturetech.safelybuy.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SignUpActivity extends AppCompatActivity {
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void goToLogin(){
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        finish();
    }

    @OnClick(R.id.sign_up_here)
    public void goToDashboard(){
        startActivity(new Intent(SignUpActivity.this, NavigationActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
