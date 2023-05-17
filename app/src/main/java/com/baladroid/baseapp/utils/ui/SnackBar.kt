package com.baladroid.baseapp.utils.ui

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

fun showSnackBar(view: View, snackText: String, isError: Boolean = false){
    //Snackbar(view)
    val snackbar = Snackbar.make(view, snackText,
        Snackbar.LENGTH_LONG)
   // snackbar.setActionTextColor(Color.BLUE)
    val snackbarView = snackbar.view
    snackbarView.setBackgroundColor(Color.LTGRAY)
    val textView =
        snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    if(isError){
        textView.setTextColor(Color.RED)
    } else {
        textView.setTextColor(Color.GREEN)
    }

    textView.textSize = 14f
    snackbar.show()
}