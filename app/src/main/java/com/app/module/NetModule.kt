package com.app.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mobile.fieldx.mainsrc.Imp_Login_Repository
import com.mobile.fieldx.mainsrc.Login_Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
class NetModule
 {
    @Inject  @BaseURL lateinit var baseURL: String

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
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://www.mocky.io/v2")
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    fun provideloginRepository(implementloginrepositor: Imp_Login_Repository): Login_Repository {
        return implementloginrepositor
    }
}