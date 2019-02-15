package com.mobile.fieldx.mainsrc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.data.model.Login_Request
import com.data.model.UserT
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loginViewModel: LoginViewModel
    @Inject
    lateinit var testInject: TestInject;

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testInject.CallWithoutProvider()
    }

    fun onLoginClick(view: View) {
        var ob = Login_Request()
        ob.client_id = BuildConfig.CLIENTID
        ob.client_secret = BuildConfig.CLIENTSECRET
        ob.grant_type = "password"
        ob.password = etPassword.text.toString()
        ob.username = etUserName.text.toString()
        loginViewModel.loadMovies(ob)
        var us = UserT()
        us.name = "RAJAN GUPTA"
        us.job = "leader"

        loginViewModel.callcreateUser(us)
        testInject.CallWithoutProvider()
    }
}
