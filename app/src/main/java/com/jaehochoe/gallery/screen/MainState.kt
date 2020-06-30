package com.jaehochoe.gallery.screen

import com.jaehochoe.gallery.model.Image
import com.jaehochoe.gallery.model.ImageSource
import com.mrt.box.core.BoxState

/**
 * Created by jaehochoe on 2020/06/27.
 */
data class MainState(
    val onProgress: Boolean = false,
    val onError: Boolean = false,
    val source: ImageSource? = null,
    val images: List<Image>? = null
) : BoxState