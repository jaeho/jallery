package com.kakaocorp.gallery.screen

import com.kakaocorp.gallery.model.Image
import com.kakaocorp.gallery.model.ImageSource
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