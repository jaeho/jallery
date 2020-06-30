package com.jaehochoe.gallery.di

import com.jaehochoe.gallery.screen.MainScreen
import dagger.Component

/**
 * Created by jaehochoe on 2020/06/27.
 */
@PerActivity
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainScreen)

}
