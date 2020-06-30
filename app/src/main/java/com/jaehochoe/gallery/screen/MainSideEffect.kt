package com.jaehochoe.gallery.screen

import com.jaehochoe.gallery.model.ImageSource
import com.mrt.box.core.BoxSideEffect

/**
 * Created by jaehochoe on 2020/06/27.
 */
sealed class MainSideEffect : BoxSideEffect {

    data class RequestGettyImagesHtml(val source: ImageSource) : MainSideEffect()
}

