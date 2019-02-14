package com.mobile.fieldx.mainsrc

import com.data.model.Login_Request
import com.retrofit.apicall.ApiHelper
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

/*Start API Call */
class Login_Service @Inject constructor(retrofit: Retrofit) : ApiHelper {

    private val retroFit by lazy { retrofit.create(ApiHelper::class.java) }

    override fun getLoginAPICall(header: Map<String, String>, requestdata: Login_Request): Call<String> {// Call<List<Login_Data>>
        println("FInal REQ  " + header)
        println("FInal REQ  " + requestdata.client_id+requestdata.username+requestdata.password)
        return retroFit.getLoginAPICall(header, requestdata)
    }

}