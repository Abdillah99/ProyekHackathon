package com.tai.app.proyekhackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void login(){
        Intent i = new Intent(LoginActivity.this, LoginForm.class);
        startActivity(i);
    }

    @OnClick(R.id.btnSignUp)
    public void signUp(){
        Intent i = new Intent(LoginActivity.this, RegisterForm.class);
        startActivity(i);
    }
    @OnClick(R.id.btnMenu)
    public void menu(){
        Intent i = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(i);
    }

}
