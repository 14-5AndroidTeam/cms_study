package com.nise.paste.Data

import com.nise.paste.Data.DTO.ToDoList
import com.nise.paste.Data.DTO.Todos
import com.nise.paste.Data.DTO.toDo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    //@GET("/members")
    //fun getMemberList():Call<Form>
    @GET("/todos")
    fun getTodoList():Call<ToDoList>
    @POST("/todos")
    fun postForm(
        @Body form: toDo
    ): Call<String>

}