package com.slideindex.app.service

import android.content.Intent
import android.os.IBinder
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import com.slideindex.app.R
import com.slideindex.app.di.AppDependencies
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class GestureToggleTileService : TileService() {

    @Inject
    lateinit var deps: AppDependencies

    private var scope: CoroutineScope? = null
    private var isServiceEnabled = false

    override fun onStartListening() {
        super.onStartListening()
        scope = CoroutineScope(Dispatchers.Main + Job())
        deps.settingsRepository.settings
            .map { it.serviceEnabled }
            .distinctUntilChanged()
            .onEach { enabled ->
                isServiceEnabled = enabled
                updateTileState(enabled)
            }
            .launchIn(scope!!)
    }

    override fun onStopListening() {
        scope?.cancel()
        scope = null
        super.onStopListening()
    }

    override fun onClick() {
        super.onClick()
        val newState = !isServiceEnabled
        scope?.launch {
            deps.settingsRepository.setServiceEnabled(newState)
        }
    }

    private fun updateTileState(enabled: Boolean) {
        val tile = qsTile ?: return
        tile.state = if (enabled) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
        tile.label = getString(R.string.tile_gesture_switch)
        tile.updateTile()
    }
}
