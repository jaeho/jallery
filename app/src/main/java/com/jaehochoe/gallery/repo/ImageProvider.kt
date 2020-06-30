package com.jaehochoe.gallery.repo

import com.jaehochoe.gallery.model.Image
import com.jaehochoe.gallery.model.ImageSource
import com.jaehochoe.gallery.model.RepoResponse

/**
 * Created by jaehochoe on 2020/06/27.
 */
interface ImageProvider {
    fun canHandleSource(src: ImageSource): Boolean
    suspend fun handleSource(src: ImageSource) : RepoResponse<List<Image>>
}