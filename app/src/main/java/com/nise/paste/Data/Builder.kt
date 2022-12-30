package com.nise.paste.Data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Builder {
    val baseUrl = "https://dh-todo.inuappcenter.kr/"

    var gson = GsonBuilder().setLenient().create()
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val apiService = retrofit.create(ApiService::class.java)
}