package com.tejas.architecturesamples.di

import android.arch.lifecycle.ViewModel
import com.tejas.architecturesamples.ui.MainActivityViewModel
import com.tejas.helpers.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Singleton
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

}