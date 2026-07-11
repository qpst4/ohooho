package com.slideindex.app.ui.a11y

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.slideindex.app.R

@Composable
fun cdNavigateBack(): String = stringResource(R.string.cd_navigate_back)

@Composable
fun cdActionConfirm(): String = stringResource(R.string.cd_action_confirm)

@Composable
fun cdBottomNavHome(): String = stringResource(R.string.main_nav_home)

@Composable
fun cdBottomNavShake(): String = stringResource(R.string.main_nav_shake)

@Composable
fun cdBottomNavNotification(): String = stringResource(R.string.main_nav_notification)

@Composable
fun cdBottomNavExtension(): String = stringResource(R.string.main_nav_extension)

@Composable
fun decorativeIconDescription(label: String): String? = label
