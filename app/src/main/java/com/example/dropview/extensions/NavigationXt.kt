package com.example.dropview.extensions

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.findNavController

fun View.navigate(directions: NavDirections, navOptions: NavOptions? = null) = try {
    findNavController().navigate(directions, navOptions)
} catch (e: IllegalArgumentException) {
    e.printStackTrace()
}