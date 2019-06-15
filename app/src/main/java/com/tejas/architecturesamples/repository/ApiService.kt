package com.tejas.architecturesamples.repository

import com.tejas.architecturesamples.ui.home.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("todos/")
    fun getData(): Call<List<MyData>?>
}

//To rebase from branch 2 @ 01:05