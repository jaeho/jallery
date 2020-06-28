package com.kakaocorp.gallery.screen

import com.kakaocorp.gallery.databinding.ScreenMainBinding
import com.mrt.box.android.BoxAndroidView
import com.mrt.box.android.BoxRenderer
import com.mrt.box.core.Vm

/**
 * Created by jaehochoe on 2020/06/27.
 */
object MainRenderer : BoxRenderer<MainState, MainEvent> {

    override fun render(v: BoxAndroidView<MainState, MainEvent>, s: MainState, vm: Vm?) {
        val binding = v.binding<ScreenMainBinding>()
        binding.onProgress = s.onProgress
        binding.onError = s.onError
        binding.source = s.source

        when (s.images != null) {
            true -> binding.nasca.loadImages(s.images.map { image -> image.url })
            else -> binding.nasca.clear()
        }
    }
}