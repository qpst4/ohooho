package com.slideindex.app.util

import android.content.Context
import android.view.inputmethod.InputMethodManager

object InputMethodHelper {

    fun switchInputMethod(context: Context): Boolean = showInputMethodPicker(context)

    fun showInputMethodPicker(context: Context): Boolean {
        val imm = context.getSystemService(InputMethodManager::class.java) ?: return false
        imm.showInputMethodPicker()
        return true
    }
}
