package com.tejas.helpers.di

import android.content.Context
import com.tejas.helpers.utils.AppExecutors
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
public class AppModule(var context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideExecutors(): AppExecutors {
        return AppExecutors()
    }
}