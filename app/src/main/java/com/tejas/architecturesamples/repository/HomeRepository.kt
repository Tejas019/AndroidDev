package com.tejas.architecturesamples.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.widget.Toast
import com.tejas.architecturesamples.ui.MyData
import com.tejas.architecturesamples.ui.MyDataDao
import com.tejas.helpers.constants.Constants.Companion.ERROR_MESSAGE_DEFAULT
import com.tejas.helpers.utils.AppExecutors
import com.tejas.helpers.utils.Resource
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

class HomeRepository @Inject constructor(val executors: AppExecutors, val mRetrofit: Retrofit, val mMyDataDao: MyDataDao) {

    val apiService = mRetrofit.create(ApiService::class.java)

    fun getData(): LiveData<Resource<List<MyData>>> {
        val result = MediatorLiveData<Resource<List<MyData>>>()
        val db = mMyDataDao.getData()
        result.addSource(db) {
            executors.mainThread().execute {
                result.value = Resource.success(it)
                if(it?.isEmpty()!!)
                    result.value = Resource.loading(null)
            }
        }
        result.value = Resource.loading(null)
        try {
            executors.networkIO().execute {
                val response = apiService.getData().execute()
                val isSuccess = response.isSuccessful

                executors.mainThread().execute {
                    if (isSuccess) {
                        result.value = Resource.success(response.body())
                    } else {
                        result.value = Resource.error(response.message(), null)
                    }
                }
            }
        } catch (e: Exception) {
            result.value = Resource.error(ERROR_MESSAGE_DEFAULT, null)
        }

        return result
    }

}