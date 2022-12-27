package com.nise.paste.Data.DTO

import com.google.gson.annotations.SerializedName

data class ToDoList(
    @SerializedName("todos")
    var todos:List<Todos>,
    @SerializedName("total_post")
    var total_post:Int,
)
