package com.kakaocorp.gallery.repo

import com.kakaocorp.gallery.model.Image
import com.kakaocorp.gallery.model.ImageSource
import com.kakaocorp.gallery.model.RepoResponse

/**
 * Created by jaehochoe on 2020/06/27.
 */
object ImageRepository {
    private val providers = arrayOf(GettyImageProvider)
    suspend fun requestImages(src: ImageSource): RepoResponse<List<Image>> {
        return providers.find { it.canHandleSource(src) }?.handleSource(src) ?: RepoResponse<List<Image>>(null, false)
    }
}