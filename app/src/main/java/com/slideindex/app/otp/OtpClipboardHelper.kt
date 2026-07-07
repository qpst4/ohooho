package com.slideindex.app.otp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import com.slideindex.app.R

object OtpClipboardHelper {
    fun copyCode(context: Context, code: String, showToast: Boolean = true) {
        val clipboard = context.getSystemService(ClipboardManager::class.java) ?: return
        clipboard.setPrimaryClip(ClipData.newPlainText("otp", code))
        if (showToast) {
            Toast.makeText(
                context,
                context.getString(R.string.otp_copied_to_clipboard, code),
                Toast.LENGTH_SHORT,
            ).show()
        }
    }
}
