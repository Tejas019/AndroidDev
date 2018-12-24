package com.tejas.architecturesamples.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.tejas.architecturesamples.repository.HomeRepository
import com.tejas.helpers.utils.Resource
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val mHomeRepository: HomeRepository): ViewModel() {


    fun getData(): LiveData<Resource<List<MyData>>> {
        return mHomeRepository.getData()
    }

}