package com.example.afiyahospital.Utilits

import android.view.View
import androidx.databinding.BindingAdapter



/**
 * Binding adapter used to hide the spinner once data is available.
 */

@BindingAdapter("isNetworkError","hospitals avilabel")
fun hideIfNetworkError(view: View, isNetWorkError: Boolean, hospitals:Any?) {
    view.visibility = if (hospitals != null) View.GONE else View.VISIBLE

    if(isNetWorkError) {
        view.visibility = View.GONE
    }
}
