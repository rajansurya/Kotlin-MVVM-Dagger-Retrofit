package com.framework.mvvm.data.local.prefs

interface PreferencesHelper {
    fun getCurrentUserId(): String
    fun setCurrentUserId(userId: String);

    fun getAccessToken(): String
    fun setAccessToken(accessToken: String);
    fun getXDeviceToken():String
    fun getAuthToken():String
    fun setAuthToken(auth:String)
}