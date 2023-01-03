package com.nise.paste.Data

import android.util.Log
import com.nise.paste.Data.DTO.Form
import com.nise.paste.Data.DTO.ToDoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    /*private  val Dr = Builder

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
    }*/

    private val Dr = Builder
    fun getList(param: GetDataCallback<ToDoList>) {
        val call = Dr.service.getList() //api 호출

        /**비동기 통신: enqueue*/
        call.enqueue(object : Callback<ToDoList>{
            override fun onResponse(call: Call<ToDoList>, response: Response<ToDoList>) {
                /**응답 성공*/
                Log.i("response", response.body().toString()) //데이터 확인
                /**Viewmodel의 인터페이스 구현부에 데이터 넘겨주기*/
                param.onSuccess(response.body())
            }

            override fun onFailure(call: Call<ToDoList>, t: Throwable) {
                /**응답 실패*/
                param.onFailure(t)
            }
        })
    }

    fun postForm(form: Form){
        val call = Dr.service.postForm(form) //api 호출

        call.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                /**응답 성공*/
                Log.i("post_Success", response.body().toString()) //데이터 확인
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                /**요청 실패*/
                Log.i("post_Failure", t.toString()) //데이터 확인
            }
        })
    }

    /**서버응답 결과를 뷰모델로 넘겨줄 수 있는 인터페이스*/
    interface GetDataCallback<T>{
        fun onSuccess(data:T?)
        fun onFailure(throwable: Throwable)
    }
}


