package com.nise.paste.Data

import android.util.Log
import com.nise.paste.Data.DTO.Form
import com.nise.paste.Data.DTO.ToDoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private  val Dr = Builder

    fun getList(param: GetDataCallback<ToDoList>) {
        val call = Builder.apiService.getList()

        call.enqueue(object : Callback<ToDoList>{

            override fun onResponse(call: Call<ToDoList>, response: Response<ToDoList>) {
                Log.i("response", response.body().toString())
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<ToDoList>, t: Throwable) {
                param.onFailure(t)
            }
        })
    }

    fun postForm(form: Form){
        val call = Builder.apiService.postForm(form)

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
        fun onSuccess(data:T?)
        fun onFailure(throwable: Throwable)
    }
}