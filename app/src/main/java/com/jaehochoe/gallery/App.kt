package com.jaehochoe.gallery

import android.app.Application
import com.mrt.box.core.Box

/**
 * Created by jaehochoe on 2020/06/27.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        when (BuildConfig.DEBUG) {
            true -> Box.enableLog { println(it) }
        }
    }
}