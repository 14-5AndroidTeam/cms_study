package com.nise.paste.Data.DTO

import com.google.gson.annotations.SerializedName

data class Todos(
    @SerializedName("id")
    var id:Int,
    @SerializedName("content")
    var content:String,
    @SerializedName("isCompleted")
    var isCompleted:Boolean
)

