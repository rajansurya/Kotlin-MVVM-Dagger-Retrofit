package com.app.module

import android.support.annotation.NonNull
import com.component.Retrofit1
import com.component.Retrofit2
import com.framework.mvvm.data.local.prefs.ImpPreferencesHelper
import com.framework.mvvm.data.local.prefs.PreferencesHelper
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mobile.kodare.mainsrc.BuildConfig
import com.mobile.kodare.mainsrc.Imp_Login_Repository
import com.mobile.kodare.mainsrc.Login_Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
        var logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(hostSelectionInterceptor).addInterceptor(logger)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRequestHeaders(): RequestHeaders {
        return RequestHeaders("https://reqres.in")
    }

    @Provides
    @Singleton
    fun providesRequestInterceptor(@NonNull requestHeaders: RequestHeaders): HostSelectionInterceptor {
        return HostSelectionInterceptor(requestHeaders);
    }

    @Provides
    @BaseURLDynamic
    fun providebaseDynamic(): String {
        return "https://reqres.in"
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }
    @Provides
    @Singleton
    @Retrofit1
    fun provideRetrofit1(gson: Gson, okHttpClient: OkHttpClient.Builder,requestHeaders: HostSelectionInterceptor): Retrofit {
        var logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        var lov=  okHttpClient.build()//.addInterceptor(logger)
        val retrofit: Retrofit = Retrofit.Builder()
                //.addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.BASE_URL)
                .client(lov)
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    @Retrofit2
    fun provideRetrofit2(gson: Gson, okHttpClient: OkHttpClient.Builder,requestHeaders: HostSelectionInterceptor): Retrofit {
        var logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        var lov=  okHttpClient.build()//.addInterceptor(logger)
        val retrofit: Retrofit = Retrofit.Builder()
                //.addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://reqres.in")
                .client(lov)
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