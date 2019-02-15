package com.app.module

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class HostSelectionInterceptor @Inject constructor(var requestHeaders:RequestHeaders ) : Interceptor {
    //@BaseURLDynamic var baseurl: String
   /* lateinit var baseurl: String
    fun setHost(url: String) {
        this.baseurl = url
    }*/

    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request: Request? = chain?.request()
        requestHeaders.baseURL?.let {
            var newurl = HttpUrl.parse(requestHeaders.baseURL)
            request = request?.newBuilder()?.url(newurl)?.build()
        }
        return chain?.proceed(request)
    }

}