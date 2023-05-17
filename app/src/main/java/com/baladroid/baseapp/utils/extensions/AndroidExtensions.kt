package com.baladroid.baseapp.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


inline fun <T> Fragment.observeLiveData(liveData: LiveData<T>, crossinline observer: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) { observer(it) }
}
fun Fragment.navigateTo(direction: NavDirections) {
    findNavController().navigate(direction)
}

fun Activity.navigateTo(navHost: Int, direction: NavDirections) {
    findNavController(navHost).navigate(direction)
}

fun ChipGroup.addChip(context: Context, label: String){

    Chip(context).apply {

        id = View.generateViewId()

        text = label

        isClickable = false

        isCheckable = false

        setChipSpacingHorizontalResource(androidx.core.R.dimen.notification_top_pad)

        isCheckedIconVisible = true

        isFocusable = true

        addView(this)

    }

}

/*fun withContext(context: Context?, lambda: (context: Context) -> Unit) {
    context?.also { lambda(it) }
}

fun Fragment.startActivity(activity: Class<*>, addExtras: (intent: Intent) -> Unit = {}) {
    withContext { it.startActivity(activity, addExtras) }
}

fun Activity.startActivity(activity: Class<*>, finish: Boolean = false, addExtras: (intent: Intent) -> Unit = {}) {
    this.startActivity(activity, addExtras)
    if (finish) finish()
}*/



fun Context.startActivity(activity: Class<*>, addExtras: (intent: Intent) -> Unit = {}) {
    startActivity(Intent(this, activity).also(addExtras))
}

 fun Activity.closeKeyboard() {
    // this will give us the view
    // which is currently focus
    // in this layout
    val view: View? = this.currentFocus

    // if nothing is currently
    // focus then this will protect
    // the app from crash
    if (view != null) {

        // now assign the system
        // service to InputMethodManager
        val manager: InputMethodManager = getSystemService(
            Context.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        manager
            .hideSoftInputFromWindow(
                view.getWindowToken(), 0
            )
    }
}

