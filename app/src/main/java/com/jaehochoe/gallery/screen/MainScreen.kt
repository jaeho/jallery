package com.jaehochoe.gallery.screen

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jaehochoe.gallery.R
import com.jaehochoe.gallery.di.ActivityModule
import com.jaehochoe.gallery.di.DaggerActivityComponent
import com.mrt.box.android.BoxActivity
import com.mrt.box.android.BoxRenderer
import com.mrt.box.android.BoxViewInitializer
import com.mrt.box.android.BoxVm
import javax.inject.Inject

/**
 * Created by jaehochoe on 2020/06/27.
 */
class MainScreen : BoxActivity<MainState, MainEvent, MainSideEffect>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    override val layout: Int
        get() = R.layout.screen_main
    override val renderer: BoxRenderer<MainState, MainEvent>?
        get() = MainRenderer
    override val viewInitializer: BoxViewInitializer<MainState, MainEvent>?
        get() = MainInitView()

    override val vm: BoxVm<MainState, MainEvent, MainSideEffect>? by lazy {
        viewModelProvider.get(MainVm::class.java)
    }

    override fun preOnCreate(savedInstanceState: Bundle?) {
        super.preOnCreate(savedInstanceState)
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}