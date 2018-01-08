package com.tai.app.proyekhackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tai.app.proyekhackathon.Model.PostPutDelUser;
import com.tai.app.proyekhackathon.Rest.ApiClient;
import com.tai.app.proyekhackathon.Rest.ApiInterface;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginForm extends AppCompatActivity{
    ApiInterface mApiInterface;

    @BindView(R.id.etUsername)
    EditText mEtUsername;
    @BindView(R.id.etPassword)
    EditText mEtPassword;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);


        ButterKnife.bind(this);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

    @OnClick(R.id.btnLogin)
    public void RequestLogin(View view){

        Call<PostPutDelUser> logReq = mApiInterface.loginRequest(mEtUsername.getText().toString(), mEtPassword.getText().toString());
        logReq.enqueue(new Callback<PostPutDelUser>() {
            @Override
            public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
               // if (response.isSuccessful()) {
                    //if (response.body().getmUser().get){
                        //


            }

            @Override
            public void onFailure(Call<PostPutDelUser> call, Throwable t) {

            }
        });
    }
}
