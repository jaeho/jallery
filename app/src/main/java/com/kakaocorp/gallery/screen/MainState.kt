package com.kakaocorp.gallery.screen

import com.kakaocorp.gallery.model.Image
import com.mrt.box.core.BoxState

/**
 * Created by jaehochoe on 2020/06/27.
 */
data class MainState(
    val onProgress: Boolean = false,
    val onError: Boolean = false,
    val images: List<Image>? = null
) : BoxState