package com.slideindex.app.service

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.slideindex.app.util.AssistantLauncher

/**
 * Invisible one-shot activity so assistant intents can be fired from overlay/service context.
 * Android 10+ blocks background activity starts from FGS; a foreground activity can relay them.
 *
 * Do not [finish] synchronously in [onCreate] — that can cancel the pending assist launch.
 */
class AssistTrampolineActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.post {
            AssistantLauncher.launchFromActivity(this)
            window.decorView.postDelayed({
                if (!isFinishing) {
                    finish()
                    @Suppress("DEPRECATION")
                    overridePendingTransition(0, 0)
                }
            }, FINISH_DELAY_MS)
        }
    }

    companion object {
        private const val FINISH_DELAY_MS = 500L

        fun createIntent(context: Context): Intent =
            Intent(context, AssistTrampolineActivity::class.java)
    }
}
