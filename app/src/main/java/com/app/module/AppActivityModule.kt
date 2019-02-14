package com.app.module

import com.mobile.fieldx.mainsrc.LoginViewModel
import com.mobile.fieldx.mainsrc.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(LoginViewModel::class))
    abstract fun bindFeedActivity(): MainActivity
}