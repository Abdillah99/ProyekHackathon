package com.tai.app.proyekhackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tai.app.proyekhackathon.Model.PostPutDelUser;
import com.tai.app.proyekhackathon.Rest.ApiClient;
import com.tai.app.proyekhackathon.Rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterForm extends AppCompatActivity {
    ApiInterface mApiInterface;

    @BindView(R.id.btnRegister)
    Button mBtnRegister;
    @BindView(R.id.etEmail) EditText mEtEmail;
    @BindView(R.id.etFullname) EditText mEtFullName;
    @BindView(R.id.etKtp) EditText mEtKtp;
    @BindView(R.id.etPassword) EditText mEtPassword;
    @BindView(R.id.etUsername) EditText mEtUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form);

        ButterKnife.bind(this);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

    }
    @OnClick(R.id.btnRegister)
    public void onClick(View view){
        Call<PostPutDelUser> postUserCall = mApiInterface.postUser(mEtUsername.getText().toString(), mEtPassword.getText().toString(), mEtFullName.getText().toString(), mEtEmail.getText().toString(),  mEtKtp.getText().toString());
        postUserCall.enqueue(new Callback<PostPutDelUser>() {
            @Override
            public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                Toast.makeText(getApplicationContext(), "BERHASIL", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "GAGAL", Toast.LENGTH_LONG).show();
            }
        });
    }





}
