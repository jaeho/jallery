package com.jaehochoe.gallery.model

import com.jaehochoe.juri.annotation.JuriModel

/**
 * Created by jaehochoe on 2020/06/27.
 */
@JuriModel(scheme = "https", host = "www.gettyimagesgallery.com", path = "/collection/{collection}")
data class GettyImagesGallery constructor(
    val collection: String
) : UriConvertible, ImageSource