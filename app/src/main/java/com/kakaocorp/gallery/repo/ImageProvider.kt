package com.kakaocorp.gallery.repo

import com.kakaocorp.gallery.model.Image
import com.kakaocorp.gallery.model.ImageSource
import com.kakaocorp.gallery.model.RepoResponse

/**
 * Created by jaehochoe on 2020/06/27.
 */
interface ImageProvider {
    fun canHandleSource(src: ImageSource): Boolean
    suspend fun handleSource(src: ImageSource) : RepoResponse<List<Image>>
}