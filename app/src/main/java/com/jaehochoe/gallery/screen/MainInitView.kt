package com.jaehochoe.gallery.screen

import android.view.View
import android.widget.AdapterView
import androidx.databinding.ViewDataBinding
import com.jaehochoe.gallery.BR
import com.jaehochoe.gallery.R
import com.jaehochoe.gallery.databinding.ScreenMainBinding
import com.jaehochoe.gallery.model.GettyImagesGallery
import com.mrt.box.android.BoxAndroidView
import com.mrt.box.android.BoxViewInitializer
import com.mrt.box.core.Vm

/**
 * Created by jaehochoe on 2020/06/28.
 */
class MainInitView : BoxViewInitializer<MainState, MainEvent> {

    override fun <B : ViewDataBinding, VM : Vm> bindingVm(b: B?, vm: VM) {
        b?.setVariable(BR.vm, vm)
    }
    override fun initializeView(v: BoxAndroidView<MainState, MainEvent>, vm: Vm?) {
        val binding = v.binding<ScreenMainBinding>()
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                try {
                    v.activity().resources.getStringArray(R.array.collections)[position].let {
                        vm?.intent(MainEvent.RequestGettyImagesHtml(GettyImagesGallery(it)))
                    }
                } catch (e: Exception) {
                    vm?.intent(MainEvent.OnError)
                }
            }
        }
        binding.spinner.setSelection(0)
    }

    override fun onCleared() {
    }
}