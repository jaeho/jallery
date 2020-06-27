package com.kakaocorp.gallery

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Created by jaehochoe on 2020/06/27.
 */

object AppStandard {
    @JvmStatic
    @BindingAdapter("goneUnless")
    fun goneUnless(view: View, visible: Boolean?) {
        view.visibility = if (visible == true) View.VISIBLE else View.GONE
    }
}