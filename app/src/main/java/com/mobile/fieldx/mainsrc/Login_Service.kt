package com.mobile.fieldx.mainsrc

import com.app.module.HostSelectionInterceptor
import com.app.module.RequestHeaders
import com.data.model.Login_Request
import com.data.model.UserT
import com.retrofit.apicall.ApiHelper
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

/*Start API Call */
class Login_Service @Inject constructor(var retrofit: Retrofit,var hostSelectionInterceptor: RequestHeaders) : ApiHelper {

    override fun createUser(user: UserT): Call<UserT> {
        //hostSelectionInterceptor.setURL("https://reqres.in")
        return retrofit.create(ApiHelper::class.java).createUser(user)
    }

   // private val retroFit by lazy { retrofit.create(ApiHelper::class.java) }

    override fun getLoginAPICall(header: Map<String, String>, requestdata: Login_Request): Call<Any> {// Call<List<Login_Data>>
//        println("FInal REQ  " + header)
//        println("FInal REQ  " + requestdata.client_id + requestdata.username + requestdata.password)
       // hostSelectionInterceptor.setURL("https://sgs-mr.payworldindia.com")
        return retrofit.create(ApiHelper::class.java).getLoginAPICall(header, requestdata)
    }


}