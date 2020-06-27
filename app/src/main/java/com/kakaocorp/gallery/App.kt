package com.kakaocorp.gallery

import android.app.Application
import com.kakaocorp.gallery.di.AppComponent
import com.kakaocorp.gallery.di.AppModule
import com.kakaocorp.gallery.di.DaggerAppComponent
import com.mrt.box.core.Box

/**
 * Created by jaehochoe on 2020/06/27.
 */
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build().apply {
                inject(this@App)
            }
    }
}