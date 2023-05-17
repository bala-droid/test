package com.baladroid.baseapp.utils

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.setVisibility(if (value) View.VISIBLE else View.GONE)
}

@BindingAdapter("android:errorText")
fun setError(tInputLayout: TextInputLayout, str: String) {
    if (!str.isNullOrEmpty()) {
        tInputLayout.error = str
    } else {
        tInputLayout.error = null
    }
}