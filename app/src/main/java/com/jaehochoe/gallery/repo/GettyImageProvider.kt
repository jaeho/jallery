package com.jaehochoe.gallery.repo

import com.jaehochoe.gallery.model.GettyImagesGallery
import com.jaehochoe.gallery.model.Image
import com.jaehochoe.gallery.model.ImageSource
import com.jaehochoe.gallery.model.RepoResponse
import org.jsoup.Jsoup

/**
 * Created by jaehochoe on 2020/06/27.
 */
object GettyImageProvider : ImageProvider {

    override fun canHandleSource(src: ImageSource): Boolean {
        return src is GettyImagesGallery
    }

    override suspend fun handleSource(src: ImageSource): RepoResponse<List<Image>> {
        val doc = Jsoup.connect((src as GettyImagesGallery).toUri()).get()
        return when (doc != null) {
            true -> {
                val list = mutableListOf<Image>()
                doc.getElementsByTag("img").forEach { element ->
                    element.attr("data-src")?.let { url ->
                        if (url.isNullOrBlank().not())
                            list.add(Image(url))
                    }
                }
                RepoResponse(list, true)
            }
            else -> RepoResponse(null, false)
        }
    }
}