package com.kakaocorp.gallery.screen

import androidx.databinding.ViewDataBinding
import com.kakaocorp.gallery.BR
import com.kakaocorp.gallery.model.GettyImagesGallery
import com.mrt.box.android.BoxAndroidView
import com.mrt.box.android.BoxViewInitializer
import com.mrt.box.core.Vm

/**
 * Created by jaehochoe on 2020/06/28.
 */
object MainInitView : BoxViewInitializer<MainState, MainEvent> {

    override fun <B : ViewDataBinding, VM : Vm> bindingVm(b: B?, vm: VM) {
        b?.setVariable(BR.vm, vm)
    }
    override fun initializeView(v: BoxAndroidView<MainState, MainEvent>, vm: Vm?) {
        vm?.intent(MainEvent.RequestGettyImagesHtml(GettyImagesGallery("sasha")))

    }
    override fun onCleared() {
    }
}