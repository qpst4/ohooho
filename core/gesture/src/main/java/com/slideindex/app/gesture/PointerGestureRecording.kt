package com.slideindex.app.gesture

import java.util.UUID

data class PointerGesturePoint(
    val x: Float,
    val y: Float,
    val offsetMs: Long,
)

data class PointerGestureRecording(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val points: List<PointerGesturePoint>,
    val createdAtEpochMs: Long = System.currentTimeMillis(),
)

object PointerGestureRecordingCodec {
    private const val ENTRY_SEP = "\u001F"
    private const val FIELD_SEP = "\u001E"
    private const val POINT_SEP = "\u001D"

    fun encode(recording: PointerGestureRecording): String {
        val points = recording.points.joinToString(POINT_SEP) { point ->
            listOf(point.x, point.y, point.offsetMs).joinToString(",")
        }
        return listOf(
            recording.id,
            recording.name,
            recording.createdAtEpochMs.toString(),
            points,
        ).joinToString(FIELD_SEP)
    }

    fun decode(raw: String): PointerGestureRecording? {
        val parts = raw.split(FIELD_SEP, limit = 4)
        if (parts.size < 4) return null
        val points = parts[3].split(POINT_SEP).mapNotNull { segment ->
            val values = segment.split(',')
            if (values.size != 3) return@mapNotNull null
            PointerGesturePoint(
                x = values[0].toFloatOrNull() ?: return@mapNotNull null,
                y = values[1].toFloatOrNull() ?: return@mapNotNull null,
                offsetMs = values[2].toLongOrNull() ?: return@mapNotNull null,
            )
        }
        if (points.size < 2) return null
        return PointerGestureRecording(
            id = parts[0],
            name = parts[1],
            createdAtEpochMs = parts[2].toLongOrNull() ?: System.currentTimeMillis(),
            points = points,
        )
    }

    fun encodeAll(recordings: List<PointerGestureRecording>): Set<String> =
        if (recordings.isEmpty()) {
            emptySet()
        } else {
            setOf(recordings.joinToString(ENTRY_SEP) { encode(it) })
        }

    fun decodeAll(raw: Set<String>): List<PointerGestureRecording> {
        if (raw.isEmpty()) return emptyList()
        return if (raw.size == 1) {
            val only = raw.first()
            if (ENTRY_SEP in only) {
                only.split(ENTRY_SEP).mapNotNull { decode(it) }
            } else {
                listOfNotNull(decode(only))
            }
        } else {
            raw.mapNotNull { decode(it) }
        }
    }
}
