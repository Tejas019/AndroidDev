package com.tejas.architecturesamples.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.tejas.architecturesamples.repository.HomeRepository
import com.tejas.helpers.utils.Resource
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val mHomeRepository: HomeRepository): ViewModel() {


    fun getData(): LiveData<Resource<List<MyData>>> {
        return mHomeRepository.getData()
    }

    var listObservable: Disposable? = null

//    init {
//        val requests = ArrayList<Observable<Resource<List<MyData>>>>()
//
//        requests.add(mHomeRepository.getData())
//        requests.add(mHomeRepository.getData())
//        requests.add(mHomeRepository.getData())
//
//        listObservable = Observable
//                .zip(requests) {
//                    // do something with those results and emit new event
//                    Any() // <-- Here we emit just new empty Object(), but you can emit anything
//                }
//                // Will be triggered if all requests will end successfully (4xx and 5xx also are successful requests too)
//                .subscribe({
//                    //Do something on successful completion of all requests
//                }) {
//                    //Do something on error completion of requests
//                }
//    }
}