package com.app.module

import android.app.Application
import android.content.Context
import com.qualifier.dagger.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppCostant.PREF_NAME
    }
}