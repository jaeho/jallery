package com.jaehochoe.gallery.screen

import com.jaehochoe.gallery.model.Image
import com.jaehochoe.gallery.model.ImageSource
import com.mrt.box.core.BoxEvent

/**
 * Created by jaehochoe on 2020/06/27.
 */
sealed class MainEvent : BoxEvent {
    data class RequestImages(val source: ImageSource) : MainEvent()
    data class OnImagesFetched(val images: List<Image>) : MainEvent()
    object OnError : MainEvent()
    data class Retry(val source: ImageSource): MainEvent()
}