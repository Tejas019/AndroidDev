package com.tejas.architecturesamples.repository

import com.tejas.architecturesamples.ui.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("todos/")
    abstract fun getData(): Call<List<MyData>?>
}