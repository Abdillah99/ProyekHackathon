package com.tai.app.proyekhackathon.Rest;

import com.tai.app.proyekhackathon.Model.GetUser;
import com.tai.app.proyekhackathon.Model.PostPutDelUser;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("db_hackton")
    Call<GetUser> getUser();

    @FormUrlEncoded
    @POST("tb_user")
    Call<PostPutDelUser> postUser(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("fullname") String fullname,
                                    @Field("email") String email,
                                    @Field("ktp") String ktp);
    @FormUrlEncoded
    @PUT("tb_user")
    Call<PostPutDelUser> putUser(@Field("username") String username,
                                 @Field("password") String password,
                                 @Field("email") String email);

    @FormUrlEncoded
    @POST("tb_user")
    Call<PostPutDelUser> loginRequest(@Field("email") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path ="tb_user", hasBody = true)
    Call<PostPutDelUser> deleteUser(@Field("id") String id);

}
