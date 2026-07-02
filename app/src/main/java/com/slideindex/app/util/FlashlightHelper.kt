package com.slideindex.app.util

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager

object FlashlightHelper {
    private var torchOn = false

    fun toggle(context: Context): Boolean {
        val cameraManager = context.getSystemService(CameraManager::class.java) ?: return false
        val cameraId = cameraManager.cameraIdList.firstOrNull { id ->
            cameraManager.getCameraCharacteristics(id)
                .get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        } ?: return false
        return runCatching {
            torchOn = !torchOn
            cameraManager.setTorchMode(cameraId, torchOn)
            true
        }.getOrDefault(false)
    }
}
