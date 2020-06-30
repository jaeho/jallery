package com.jaehochoe.gallery.model

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by jaehochoe on 2020/06/29.
 */
const val URL = "https://www.gettyimagesgallery.com/collection/sasha"

class GettyImagesGalleryTest {

    @Test
    fun `convert model to uri`() {
        val src = GettyImagesGallery("sasha")
        assertEquals(src.toUri(), URL)
    }

}