package com.kakaocorp.gallery.screen

import com.kakaocorp.gallery.model.ImageSource
import com.mrt.box.core.BoxSideEffect
import org.jsoup.nodes.Document

/**
 * Created by jaehochoe on 2020/06/27.
 */
sealed class MainSideEffect : BoxSideEffect {

    data class RequestGettyImagesHtml(val source: ImageSource) : MainSideEffect()
}

