package com.nise.paste.Data.DTO

import com.google.gson.annotations.SerializedName

data class Todos(
    /*@SerializedName("id")
    var id:Int,
    @SerializedName("content")
    var content:String,
    @SerializedName("isCompleted")
    var isCompleted:Boolean*/
    @SerializedName("_id")
    var _id:String,
    @SerializedName("id")
    var id:Int,
    @SerializedName("content")
    var content:String,
    @SerializedName("deadline")
    var deadline:String
)

