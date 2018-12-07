package com.tejas.architecturesamples.di

import android.content.Context
import com.tejas.architecturesamples.repository.AppRealmModule
import com.tejas.architecturesamples.ui.MyDataDao
import com.tejas.architecturesamples.ui.RealmMyDataDao
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RealmModule @Inject constructor(val mContext: Context) {

    companion object {
        fun init(context: Context) {
            Realm.init(context)

//            val rand = Random()
//            val encryptionKey = ByteArray(64)
//            rand.nextBytes(encryptionKey)

            val configuration = RealmConfiguration.Builder()
            configuration
                    .name("app_db")
//                    .encryptionKey(encryptionKey)
                    .modules(AppRealmModule())
                    .deleteRealmIfMigrationNeeded()
            Realm.setDefaultConfiguration(configuration.build())
        }
    }


    @Singleton
    @Provides
    fun provideRealm(): Realm {
        try {
            return Realm.getDefaultInstance()
        } catch (e: Exception) {
            e.printStackTrace()
            Realm.init(mContext)
            return Realm.getDefaultInstance()
        }
    }

    @Singleton
    @Provides
    fun provideMyDataDao(realm: Realm): MyDataDao = RealmMyDataDao(realm)
}