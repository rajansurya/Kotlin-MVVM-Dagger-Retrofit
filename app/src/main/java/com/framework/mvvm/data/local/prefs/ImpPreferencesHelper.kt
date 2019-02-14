package com.framework.mvvm.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.qualifier.dagger.PreferenceInfo
import javax.inject.Inject

class ImpPreferencesHelper @Inject constructor(context: Context, @param:PreferenceInfo prefFileName: String) : PreferencesHelper {
    override fun setAuthToken(auth: String) {
        mPrefs.edit().putString("auth_token", auth).apply()
    }

    val PREF_KEY_CURRENT_USER_ID: String = "PREF_KEY_CURRENT_USER_ID"
    val PREF_KEY_ACCESS_TOKEN: String = "PREF_KEY_ACCESS_TOKEN"
    var mPrefs: SharedPreferences

    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }

    override fun getCurrentUserId(): String {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_ID, "");
    }

    override fun setCurrentUserId(userId: String) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ID, userId).apply()
    }

    override fun getAccessToken(): String {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "");
    }

    override fun setAccessToken(accessToken: String) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()
    }

    override fun getXDeviceToken(): String {
        return mPrefs.getString("X-device-token", "");
    }

    override fun getAuthToken(): String {
        return mPrefs.getString("auth_token", "");
    }

}