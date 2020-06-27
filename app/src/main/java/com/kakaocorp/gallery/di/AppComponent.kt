package com.kakaocorp.gallery.di

import com.kakaocorp.gallery.App
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by jaehochoe on 2020/06/27.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class] )
interface AppComponent {
    fun inject(app: App)
}