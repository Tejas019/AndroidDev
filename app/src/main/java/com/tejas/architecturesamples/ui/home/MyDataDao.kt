package com.tejas.architecturesamples.ui.home

import android.arch.lifecycle.LiveData

interface MyDataDao {

    fun insertData(myDataList: List<MyData>)
    fun getData(): LiveData<List<MyData>>
}