package com.mobile.fieldx.mainsrc

import com.data.model.Login_Request
import com.data.model.UserT
import dagger.Module
import retrofit2.Call
import javax.inject.Inject


@Module
class LoginViewModel @Inject constructor(private var getmoview: Login_Repository) {//Login_Response

    fun loadMovies(requestdata: Login_Request):Call<String> = getmoview.getLoginResponse(requestdata)
    fun callcreateUser(user: UserT):Call<UserT> = getmoview.createUser(user)

}