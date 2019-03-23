package com.tejas.architecturesamples.ui.home

import android.arch.lifecycle.LiveData
import io.reactivex.Single
import retrofit2.Call
import java.util.*

interface MyDataDao {

    fun insertData(myDataList: List<MyData>)
    fun getData(): LiveData<List<MyData>>
//    fun getDataObs(): Single<List<MyData>>
}