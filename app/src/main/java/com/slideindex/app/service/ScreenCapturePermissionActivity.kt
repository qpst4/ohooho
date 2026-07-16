package com.slideindex.app.service

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.projection.MediaProjectionManager
import com.slideindex.app.util.MediaProjectionStore

/**
 * Transparent trampoline that hosts [MediaProjectionManager.createScreenCaptureIntent] so screen
 * capture consent can be obtained from overlay / service contexts (Android 10+).
 */
class ScreenCapturePermissionActivity : Activity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        val manager = getSystemService(MediaProjectionManager::class.java)
        @Suppress("DEPRECATION")
        startActivityForResult(manager.createScreenCaptureIntent(), REQUEST_CODE)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            MediaProjectionStore.save(this, resultCode, data)
            when (readPurpose()) {
                Purpose.SCREEN_CAPTURE -> ScreenCaptureService.start(this, resultCode, data)
                Purpose.SCREEN_RECORD -> ScreenRecordService.start(this, resultCode, data)
            }
        }
        finish()
        @Suppress("DEPRECATION")
        overridePendingTransition(0, 0)
    }

    private fun readPurpose(): Purpose {
        val raw = intent.getStringExtra(EXTRA_PURPOSE)
        return Purpose.entries.firstOrNull { it.name == raw } ?: Purpose.SCREEN_RECORD
    }

    enum class Purpose {
        SCREEN_CAPTURE,
        SCREEN_RECORD,
    }

    companion object {
        private const val REQUEST_CODE = 9101
        private const val EXTRA_PURPOSE = "purpose"

        fun createIntent(context: Context, purpose: Purpose): Intent =
            Intent(context, ScreenCapturePermissionActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(EXTRA_PURPOSE, purpose.name)
            }
    }
}
