package com.kakaocorp.gallery.screen

import com.kakaocorp.gallery.model.Image
import com.kakaocorp.gallery.model.ImageSource
import com.mrt.box.core.BoxEvent

/**
 * Created by jaehochoe on 2020/06/27.
 */
sealed class MainEvent : BoxEvent {

    data class RequestGettyImagesHtml(val source: ImageSource) : MainEvent()
    data class OnImagesFetched(val images: List<Image>) : MainEvent()
    object OnError : MainEvent()

}