package com.slideindex.app.otp

import java.util.UUID

data class OtpRecord(
    val id: String = UUID.randomUUID().toString(),
    val code: String,
    val packageName: String,
    val title: String,
    val text: String,
    val timestampMs: Long,
    val ruleName: String? = null,
    val isTest: Boolean = false,
)
