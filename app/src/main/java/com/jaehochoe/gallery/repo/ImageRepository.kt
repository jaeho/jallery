package com.jaehochoe.gallery.repo

import com.jaehochoe.gallery.model.Image
import com.jaehochoe.gallery.model.ImageSource
import com.jaehochoe.gallery.model.RepoResponse

/**
 * Created by jaehochoe on 2020/06/27.
 */
object ImageRepository {
    private val providers = arrayOf<ImageProvider>(GettyImageProvider)
    suspend fun requestImages(src: ImageSource): RepoResponse<List<Image>> {
        return try {
            providers.find { it.canHandleSource(src) }?.handleSource(src)
                ?: RepoResponse<List<Image>>(null, false)
        } catch (e: Exception) {
            RepoResponse<List<Image>>(null, false)
        }
    }
}