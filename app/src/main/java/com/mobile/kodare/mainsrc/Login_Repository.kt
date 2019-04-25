package com.mobile.kodare.mainsrc

import com.data.model.Login_Request
import com.data.model.UserT
import retrofit2.Call

interface Login_Repository {
    fun getLoginResponse(requestdata: Login_Request): Call<Any>//Call<List<Login_Data>>
    fun createUser(user: UserT): Call<UserT>
}