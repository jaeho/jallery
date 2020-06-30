package com.jaehochoe.gallery.screen

import com.jaehochoe.gallery.VmTest
import com.jaehochoe.gallery.model.GettyImagesGallery
import com.jaehochoe.gallery.model.Image
import com.mrt.box.core.BoxBlueprint
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by jaehochoe on 2020/06/28.
 */
class MainVmTest : VmTest<MainState, MainEvent, MainSideEffect>() {

    override val vm: MainVm = mock(MainVm::class.java)

    override fun emptyState(): MainState {
        return MainState()
    }

    override fun mockBlueprint(): BoxBlueprint<MainState, MainEvent, MainSideEffect> {
        return vm.onCreatedBlueprint()
    }

    @Test
    fun `intent RequestGettyImagesHtml`() {
        val src = mock(GettyImagesGallery::class.java)
        val output = vm.testIntent(MainEvent.RequestGettyImagesHtml(src))
        output.valid().to.apply {
            assertFalse(onError)
            assertTrue(onProgress)
            assertEquals(source, src)
        }
        output.valid().sideEffect.apply {
            assertTrue(this is MainSideEffect.RequestGettyImagesHtml)
        }
        runBlocking {
            doIoSideEffect(output.valid())
            verify(vm).requestGettyImageHtmlAsync(src)
        }
    }

    @Test
    fun `intent OnImagesFetched`() {
        val mock = mock(List::class.java)
        val output = vm.testIntent(MainEvent.OnImagesFetched(images = mock as List<Image>))
        output.valid().to.apply {
            assertFalse(onProgress)
            assertEquals(images, mock)
        }
    }

    @Test
    fun `intent OnError`() {
        val output = vm.testIntent(MainEvent.OnError)
        output.valid().to.apply {
            assertTrue(onError)
            assertFalse(onProgress)
        }
    }

    @Test
    fun `intent Retry`() {
        val src = mock(GettyImagesGallery::class.java)
        val output = vm.testIntent(MainEvent.Retry(src))
        output.valid().to.apply {
            assertFalse(onError)
            assertTrue(onProgress)
            assertNull(images)
        }
        output.valid().sideEffect.apply {
            assertTrue(this is MainSideEffect.RequestGettyImagesHtml)
        }
        runBlocking {
            doIoSideEffect(output.valid())
            verify(vm).requestGettyImageHtmlAsync(src)
        }
    }
}