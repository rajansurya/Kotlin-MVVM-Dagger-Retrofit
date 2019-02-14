package com.mobile.fieldx.mainsrc

import com.data.model.Login_Data
import com.data.model.Login_Request
import retrofit2.Call

interface Login_Repository{
    fun getLoginResponse(requestdata:Login_Request):Call<String>//Call<List<Login_Data>>
}