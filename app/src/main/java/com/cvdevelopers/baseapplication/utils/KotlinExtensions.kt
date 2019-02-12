package com.cvdevelopers.baseapplication.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import java.math.BigDecimal

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun String.toCurrencyFormat(): String {
    return "$${BigDecimal.valueOf(this.toDouble()).setScale(2)}"
}