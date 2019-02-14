package com.mobile.fieldx.mainsrc

import android.util.Log
import com.data.model.Login_Request
import com.framework.mvvm.data.local.prefs.PreferencesHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.NetworkInterface
import java.util.*
import javax.inject.Inject

class Imp_Login_Repository @Inject constructor(var loginservice: Login_Service, var preferencesHelper: PreferencesHelper) : Login_Repository {

    override fun getLoginResponse(requestdata: Login_Request): Call<String> {//Call<List<Login_Data>>
        println("FFF   " + loginservice.getLoginAPICall(setHeader(), requestdata).enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                Log.i("Response   DDD", response?.body().toString());
            }

        }))
        return loginservice.getLoginAPICall(setHeader(), requestdata)
    }

    fun setHeader(): Map<String, String> {
        preferencesHelper.setAccessToken("jkahdfhdqwjRAJAN2342344324")
        preferencesHelper.setAuthToken("GGGGGGGGGGGGGGGGG")
        var map = HashMap<String, String>()
        map.put("Content-Type", "application/json")
        map.put("X-device-token", preferencesHelper.getAccessToken())
        map.put("Authorization", preferencesHelper.getAuthToken())
        map.put("X-Client-Ip", getIPAddress(true))
        map.put("x-client-id", BuildConfig.CLIENTID)
        map.put("sales-executive-login", "1")
        println("map " + map)
        return map
    }

    fun getIPAddress(useIPv4: Boolean): String {
        try {
            val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())
            for (intf in interfaces) {
                val addrs = Collections.list(intf.inetAddresses)
                for (addr in addrs) {
                    if (!addr.isLoopbackAddress) {
                        val sAddr = addr.hostAddress
                        //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        val isIPv4 = sAddr.indexOf(':') < 0

                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr
                        } else {
                            if (!isIPv4) {
                                val delim = sAddr.indexOf('%') // drop ip6 zone suffix
                                return if (delim < 0) sAddr.toUpperCase() else sAddr.substring(0, delim).toUpperCase()
                            }
                        }
                    }
                }
            }
        } catch (ex: Exception) {
        }
        // for now eat exceptions
        return ""
    }

}