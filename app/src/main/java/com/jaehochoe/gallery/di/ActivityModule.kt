package com.jaehochoe.gallery.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

/**
 * Created by jaehochoe on 2020/06/27.
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(activity.viewModelStore, ViewModelProvider.AndroidViewModelFactory.getInstance(activity.application))
    }

}