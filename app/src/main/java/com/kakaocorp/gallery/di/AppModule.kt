package com.kakaocorp.gallery.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jaehochoe on 2020/06/27.
 */
@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    @AppContext
    fun provideContext(): Context {
        return app.applicationContext
    }
}