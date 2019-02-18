package com.mobile.kodare.mainsrc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.data.model.UserT
import com.mobile.kodare.mainsrc.LoginViewModel
import com.mobile.kodare.mainsrc.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class OtherViewtest : AppCompatActivity() {
    @Inject
    lateinit var loginViewModel: LoginViewModel
    @Inject
    lateinit var otherview: TestInject

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var us = UserT()
        us.name = "RAJAN GUPTA"
        us.job = "leader"
        otherview.CallWithoutProvider()
        //loginViewModel.callcreateUser(us)

    }
}