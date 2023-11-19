package me.adipiscing_elit.hewahbnb.util

import android.widget.Toast

fun showToast(context: android.content.Context, message: String) {
    val density = context.resources.displayMetrics.density
    val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    toast.setGravity(
        android.view.Gravity.BOTTOM or android.view.Gravity.CENTER_HORIZONTAL,
        0,
        (16 * density).toInt()
    )
    toast.show()
}