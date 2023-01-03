package com.nise.paste.Data

import com.nise.paste.Data.DTO.Form
import com.nise.paste.Data.DTO.ToDoList
import com.nise.paste.Data.DTO.Todos
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    //@GET("/members")
    //fun getMemberList():Call<Form>
    /*@GET("/todos")
    fun getTodoList():Call<ToDoList>
    @POST("/todos")
    fun postForm(
        @Body form: toDo
    ): Call<String>
*/
    @GET("/todos") //todolist 불러오는 api
    fun getList(): Call<ToDoList>

    @POST("/todos")
    fun postForm(
        @Body form: Form
    ):Call<String>

}