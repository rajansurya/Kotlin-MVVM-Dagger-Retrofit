package com.component

import android.app.Activity
import android.app.Application
import android.support.multidex.MultiDexApplication
import com.app.module.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AndroidApplication : Application(), HasActivityInjector  {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).netModulesetter("http://www.mocky.io/v2").build().inject(this)
    }
}