package com.mobile.fieldx.mainsrc

import com.data.model.Login_Request
import dagger.Module
import javax.inject.Inject


@Module
class LoginViewModel @Inject constructor(private var getmoview: Login_Repository) {//Login_Response

    fun loadMovies(requestdata:Login_Request) = getmoview.getLoginResponse(requestdata)

}