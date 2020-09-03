package com.jaehochoe.gallery.screen

import com.jaehochoe.gallery.databinding.ScreenMainBinding
import com.jaehochoe.gallery.model.Image
import com.jaehochoe.gallery.model.ImageSource
import com.mrt.box.android.BoxAndroidView
import com.mrt.box.core.Vm
import com.mrt.nasca.NascaView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Created by jaehochoe on 2020/06/30.
 */
class MainRendererTest {

    private val v = mock(BoxAndroidView::class.java)
    private val binding = mock(ScreenMainBinding::class.java)
    private val vm = mock(Vm::class.java)

    @Before
    fun setUp() {
        `when`(v.binding<ScreenMainBinding>()).thenReturn(binding)
        val f = ScreenMainBinding::class.java.getDeclaredField("nasca")
        f.isAccessible = true
        f[binding] = mock(NascaView::class.java)
    }

    @Test
    fun `render progress`() {
        val s = MainState(onProgress = true)
        MainRenderer.renderView(v, s, vm)
        verify(binding).onProgress = true
    }

    @Test
    fun `render error`() {
        val s = MainState(onError = true)
        MainRenderer.renderView(v, s, vm)
        verify(binding).onError = true
    }

    @Test
    fun `render source`() {
        val source = mock(ImageSource::class.java)
        val s = MainState(source = source)
        MainRenderer.renderView(v, s, vm)
        verify(binding).source = source
    }

    @Test
    fun `render images`() {
        val images = listOf(Image("mockUrl"))
        val s = MainState(images = images)
        MainRenderer.renderView(v, s, vm)
        verify(binding.nasca).loadImages(images.map { image -> image.url })
    }

    @Test
    fun `render clear images`() {
        val s = MainState(images = null)
        MainRenderer.renderView(v, s, vm)
        verify(binding.nasca).clear()
    }

}