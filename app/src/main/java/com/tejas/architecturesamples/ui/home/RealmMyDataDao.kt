package com.tejas.architecturesamples.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.realm.Realm

class RealmMyDataDao(val realm: Realm): MyDataDao {

    override fun insertData(myDataList: List<MyData>) {
        realm.executeTransaction {
            it.where(MyData::class.java).findAll().deleteAllFromRealm()
            it.insertOrUpdate(myDataList)
        }
    }

    override fun getData(): LiveData<List<MyData>> {
        val db = MutableLiveData<List<MyData>>()
        val list = realm.where(MyData::class.java).findAll()
        list?.let {
            if(it.isNotEmpty())
                db.value = realm.copyFromRealm(list)
            else
                db.value = listOf()
        }
        return db
    }
}