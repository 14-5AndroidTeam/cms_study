package com.nise.paste.Data

import android.util.Log
import com.nise.paste.Data.DTO.ToDoList
import com.nise.paste.Data.DTO.toDo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private  val Dr = Builder

    fun getList(param: GetDataCallback<ToDoList>) {
        val call = Dr.apiService.getTodoList()

        call.enqueue(object : Callback<ToDoList>{
            override fun onResponse(callMember: Call<ToDoList>, response: Response<ToDoList>) {
                Log.i("response", response.body().toString())
                param.onSuccess(response.body())
            }
            override fun onFailure(callMember: Call<ToDoList>, t: Throwable) {
                param.onFailure(t)
            }
        })


    }


    fun postForm(toDo: toDo){
        val call = Builder.apiService.postForm(toDo)

        call.enqueue(object:Callback<String>{

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.i("post_Success",response.body().toString())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.i("post_Failure",t.toString())
            }
        })
    }

    interface GetDataCallback<T>{
        fun onSuccess(data: ToDoList?)
        fun onFailure(throwable: Throwable)
    }
}


