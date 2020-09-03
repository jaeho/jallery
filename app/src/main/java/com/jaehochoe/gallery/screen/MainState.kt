package com.jaehochoe.gallery.screen

import com.jaehochoe.gallery.model.Image
import com.jaehochoe.gallery.model.ImageSource
import com.mrt.box.android.BoxRenderingScope
import com.mrt.box.core.BoxState

data class MainState(
    val onProgress: Boolean = false,
    val onError: Boolean = false,
    val source: ImageSource? = null,
    val images: List<Image>? = null
) : BoxState {
    override var scope: BoxRenderingScope? = null
}