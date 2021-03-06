package com.jaehochoe.gallery.screen

import com.jaehochoe.gallery.model.ImageSource
import com.jaehochoe.gallery.repo.ImageRepository
import com.mrt.box.android.BoxVm
import com.mrt.box.core.BoxBlueprint
import com.mrt.box.core.bluePrint

/**
 * Created by jaehochoe on 2020/06/27.
 */
class MainVm : BoxVm<MainState, MainEvent, MainSideEffect>() {

    override val bluePrint: BoxBlueprint<MainState, MainEvent, MainSideEffect>
        get() = onCreatedBlueprint()

    suspend fun requestGettyImageHtmlAsync(source: ImageSource): MainEvent {
        val response = ImageRepository.requestImages(source)
        return when (response.isSuccess && response.data != null) {
            true -> MainEvent.OnImagesFetched(response.data)
            else -> MainEvent.OnError
        }
    }
}

fun MainVm.onCreatedBlueprint(): BoxBlueprint<MainState, MainEvent, MainSideEffect> {
    return bluePrint(MainState()) {
        on<MainEvent.RequestImages> {
            to(copy(onProgress = true, onError = false, source = it.source), MainSideEffect.RequestImages(it.source))
        }
        io<MainSideEffect.RequestImages> {
            requestGettyImageHtmlAsync(it.sideEffect.source)
        }

        on<MainEvent.OnImagesFetched> {
            to(copy(onProgress = false, images = it.images))
        }

        on<MainEvent.OnError> {
            to(copy(onError = true, onProgress = false))
        }

        on<MainEvent.Retry> {
            to(copy(onError = false, onProgress = true, images = null), MainSideEffect.RequestImages(it.source))
        }
    }
}