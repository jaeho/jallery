package com.jaehochoe.gallery.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jaehochoe.gallery.model.GettyImagesGallery
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

/**
 * Created by jaehochoe on 2020/06/29.
 */
class ImageRepositoryTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `requestImages succeed`() {
        runBlocking {
            val src = GettyImagesGallery("sasha")
            val response = ImageRepository.requestImages(src)
            assertNotNull(response)
            assertTrue(response.isSuccess)
        }
    }

    @Test
    fun `requestImages failed`() {
        runBlocking {
            val src = GettyImagesGallery("ssasha")
            val response = ImageRepository.requestImages(src)
            assertNotNull(response)
            assertFalse(response.isSuccess)
        }
    }

}