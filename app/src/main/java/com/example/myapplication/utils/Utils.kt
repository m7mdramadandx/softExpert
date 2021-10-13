package com.example.myapplication.utils

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.myapplication.R

object Utils {

    fun circularDrawable(context: Context): CircularProgressDrawable {
        val drawable = CircularProgressDrawable(context)
        drawable.setColorSchemeColors(ContextCompat.getColor(context, R.color.purple_500))
        drawable.centerRadius = 30f
        drawable.strokeWidth = 5f
        drawable.start()
        return drawable
    }
}