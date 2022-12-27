package com.nise.paste.Data

import com.nise.paste.Data.DTO.Form
import com.nise.paste.Data.DTO.ToDoList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/todos")
    fun getList():Call<ToDoList>
    @POST("/todos")
    fun postForm(
        @Body form : Form
    ): Call<String>
}