package com.mobile.fieldx.mainsrc

import com.data.model.Login_Data
import retrofit2.Call
import javax.inject.Inject

class Imp_Login_Repository @Inject constructor(var loginservice:Login_Service):Login_Repository{

    override fun getLoginResponse(): Call<List<Login_Data>> {
       return loginservice.getLoginAPICall()
    }

}