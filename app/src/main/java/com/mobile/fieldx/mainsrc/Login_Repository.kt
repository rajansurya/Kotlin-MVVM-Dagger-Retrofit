package com.mobile.fieldx.mainsrc

import com.data.model.Login_Data
import retrofit2.Call

interface Login_Repository{
    fun getLoginResponse():Call<List<Login_Data>>
}