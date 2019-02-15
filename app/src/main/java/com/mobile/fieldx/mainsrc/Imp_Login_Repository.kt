package com.mobile.fieldx.mainsrc

import android.util.Log
import com.data.model.Login_Request
import com.data.model.UserT
import com.framework.mvvm.data.local.prefs.PreferencesHelper
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.NetworkInterface
import java.util.*
import javax.inject.Inject

class Imp_Login_Repository @Inject constructor(var loginservice: Login_Service, var preferencesHelper: PreferencesHelper) : Login_Repository {

    override fun createUser(user: UserT): Call<UserT> {
        var ob: Call<UserT> = loginservice.createUser(user)
        ob.enqueue(object : Callback<UserT> {
            override fun onResponse(call: Call<UserT>?, response: Response<UserT>) {
                var ii: UserT? = response.body()
                Log.i(" Response REQRES ", ii?.toString());
            }

            override fun onFailure(call: Call<UserT>?, t: Throwable?) {
                Log.i(" Response REQRES ", t?.stackTrace.toString());
            }

        })
        return ob
    }

    override fun getLoginResponse(requestdata: Login_Request): Call<Any> {//Call<List<Login_Data>>
        var oo: Call<Any> = loginservice.getLoginAPICall(setHeader(), requestdata)
        oo.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                Log.i("Response   onFailure ", t?.stackTrace.toString());
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>) {
                if (response.isSuccessful)
                    Log.i(" RAJAN FieldX  ", Gson().toJson(response?.body()));
                else
                    Log.i("NOT  RAJAN FieldX  ", response.errorBody()?.string());

            }


        })
        return oo
    }

    fun setHeader(): Map<String, String> {
//        preferencesHelper.setAccessToken("jkahdfhdqwjRAJAN2342344324")
//        preferencesHelper.setAuthToken("GGGGGGGGGGGGGGGGG")
        var map = HashMap<String, String>()
        map.put("Content-Type", "application/json")
        map.put("X-device-token", preferencesHelper.getAccessToken())
        map.put("Authorization", preferencesHelper.getAuthToken())
        map.put("X-Client-Ip", getIPAddress(true))
        map.put("x-client-id", BuildConfig.CLIENTID)
        map.put("sales-executive-login", "1")
        //println("map " + map)
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