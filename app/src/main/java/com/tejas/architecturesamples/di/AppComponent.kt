package com.tejas.architecturesamples.di

import com.tejas.architecturesamples.ui.home.MainActivity
import com.tejas.helpers.di.AppModule
import com.tejas.helpers.di.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, RetrofitModule::class, RealmModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}