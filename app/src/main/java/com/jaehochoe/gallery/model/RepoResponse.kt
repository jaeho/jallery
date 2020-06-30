package com.jaehochoe.gallery.model

/**
 * Created by jaehochoe on 2020/06/27.
 */
data class RepoResponse <T> (
    val data: T?,
    val isSuccess: Boolean
)