package com.retrofit.apicall

import com.data.model.Login_Data
import com.data.model.Login_Request
import com.data.model.UserT
import retrofit2.Call
import retrofit2.http.*


interface ApiHelper {
    //@FormUrlEncoded
    @POST("/oauth/token")
    fun getLoginAPICall(@HeaderMap header: Map<String, String>, @Body requestdata: Login_Request): Call<Any> //Call<List<Login_Data>>

    @POST("/api/users")
    fun createUser(@Body user: UserT):Call<UserT>
}