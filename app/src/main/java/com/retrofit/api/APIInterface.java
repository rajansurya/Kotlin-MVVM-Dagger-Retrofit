package com.retrofit.api;


import com.retrofit.api.pojo.MultipleResource;
import com.retrofit.api.pojo.User;
import com.retrofit.api.pojo.UserList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;



interface APIInterface {

    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @GET("/photos")
    Call<ResponseBody> createUser();

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
