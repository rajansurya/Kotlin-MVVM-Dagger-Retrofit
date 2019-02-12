package com.mobile.fieldx.mainsrc

import dagger.Module
import javax.inject.Inject


@Module
class LoginViewModel @Inject constructor(private var getmoview: Login_Response) {

    fun loadMovies() = getmoview.backToView()
}