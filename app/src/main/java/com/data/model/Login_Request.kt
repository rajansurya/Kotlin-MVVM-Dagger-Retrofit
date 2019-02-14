package com.data.model

import com.google.gson.annotations.SerializedName

class Login_Request {
    @SerializedName("username")
    lateinit var username: String
    @SerializedName("password")
    lateinit var password: String
    @SerializedName("grant_type")
    lateinit var grant_type: String
    @SerializedName("client_id")
    lateinit var client_id: String
    @SerializedName("client_secret")
    lateinit var client_secret: String
}