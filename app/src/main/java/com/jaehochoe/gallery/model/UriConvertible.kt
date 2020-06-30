package com.jaehochoe.gallery.model

import com.jaehochoe.juri.Juri

/**
 * Created by jaehochoe on 2020/06/27.
 */
interface UriConvertible {
    fun toUri(): String {
        return Juri.toUri(this)
    }
}