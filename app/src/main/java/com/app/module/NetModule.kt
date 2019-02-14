package com.app.module

import com.framework.mvvm.data.local.prefs.ImpPreferencesHelper
import com.framework.mvvm.data.local.prefs.PreferencesHelper
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mobile.fieldx.mainsrc.BuildConfig
import com.mobile.fieldx.mainsrc.Imp_Login_Repository
import com.mobile.fieldx.mainsrc.Login_Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
class NetModule {
    @Inject
    @BaseURL
    lateinit var baseURL: String

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @BaseURL
    fun peovideBaseUrl(): String {
        return "http://www.mocky.io/v2"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(hostSelectionInterceptor: HostSelectionInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder().addInterceptor(hostSelectionInterceptor)
        return client.build()
    }

    @Provides
    @BaseURLDynamic
    fun providebaseDynamic():String{
        return "https://reqres.in"
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
                //.addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.BASE_URL)//
                .client(okHttpClient)
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideloginRepository(implementloginrepositor: Imp_Login_Repository): Login_Repository {
        return implementloginrepositor
    }

    @Provides
    @Singleton
    fun providePreferance(imp_preference: ImpPreferencesHelper): PreferencesHelper {
        return imp_preference
    }
}