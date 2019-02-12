package com.mobile.fieldx.mainsrc

import com.data.model.Login_Data
import com.retrofit.apicall.ApiHelper
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

/*Start API Call */
class Login_Service @Inject constructor(retrofit: Retrofit) : ApiHelper {

    private val loginapi by lazy { retrofit.create(ApiHelper::class.java) }

    override fun getLoginAPICall(): Call<List<Login_Data>> {
        return loginapi.getLoginAPICall()
    }

}