package com.retrofit.apicall

import com.data.model.Login_Data
import retrofit2.Call
import retrofit2.http.POST

interface ApiHelper {
    @POST("sgs/login/")
    fun getLoginAPICall(): Call<List<Login_Data>>
}