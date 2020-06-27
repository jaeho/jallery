package com.kakaocorp.gallery.di

import com.kakaocorp.gallery.screen.MainScreen
import dagger.Component

/**
 * Created by jaehochoe on 2020/06/27.
 */
@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainScreen)

}
