package com.data.model
import com.google.gson.annotations.SerializedName

 class UserT {

    @SerializedName("name")
    lateinit var name: String;
    @SerializedName("job")
    lateinit var job: String;
    @SerializedName("id")
    lateinit var id: String;
    @SerializedName("createdAt")
    lateinit var createdAt: String;

}

