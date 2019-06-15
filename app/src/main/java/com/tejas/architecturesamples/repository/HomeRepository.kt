package com.tejas.architecturesamples.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.tejas.architecturesamples.ui.home.MyData
import com.tejas.architecturesamples.ui.home.MyDataDao
import com.tejas.helpers.utils.AppExecutors
import com.tejas.helpers.utils.Resource
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

class HomeRepository @Inject constructor(private val mExecutors: AppExecutors, mRetrofit: Retrofit, private val mMyDataDao: MyDataDao) {

    private val mApiService = mRetrofit.create(ApiService::class.java)

    fun getData(): LiveData<Resource<List<MyData>>> {
        val result = MediatorLiveData<Resource<List<MyData>>>()
        val db = mMyDataDao.getData()
        result.addSource(db) {
            result.value = Resource.success(it)
            if (it?.isEmpty()!!)
                result.value = Resource.loading(null)
            result.removeSource(db)
        }
        result.value = Resource.loading(null)

        mExecutors.networkIO().execute {
            try {
                val response = mApiService.getData().execute()
                val isSuccess = response.isSuccessful

                mExecutors.mainThread().execute {
                    if (isSuccess) {
                        result.value = Resource.success(response.body())
                        mMyDataDao.insertData(response.body()!!)
                    } else {
                        result.value = Resource.error(response.message(), null)
                    }
                }
            } catch (e: Exception) {
                mExecutors.mainThread().execute {
                    result.value = Resource.unsuccessful(Resource.getExceptionMessage(e))
                }
            }
        }
        return result
    }
}