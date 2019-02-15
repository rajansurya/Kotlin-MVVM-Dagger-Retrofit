package com.app.module

import javax.inject.Inject

class RequestHeaders @Inject constructor(var baseURL: String){
//    lateinit var baseURL: String
    fun setURL(url: String) {
        baseURL = url
    }

    fun getURL(): String {
        return baseURL
    }
}