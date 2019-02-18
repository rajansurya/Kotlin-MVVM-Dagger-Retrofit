package com.app.module

import com.mobile.kodare.mainsrc.LoginViewModel
import com.mobile.kodare.mainsrc.MainActivity
import com.mobile.kodare.mainsrc.OtherViewtest
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(LoginViewModel::class))
    abstract fun bindFeedActivity(): MainActivity
    @ContributesAndroidInjector(modules = arrayOf(LoginViewModel::class))
    abstract fun bindOthertest(): OtherViewtest
}