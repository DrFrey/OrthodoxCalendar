package com.example.orthodoxcalendar.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable


@Composable
fun AnimatedContainer(
    state: MutableTransitionState<Boolean>,
    enter: EnterTransition = slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(durationMillis = 320)
    ),
    exit: ExitTransition = slideOutHorizontally(
        targetOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(durationMillis = 320)
    ),
    content: @Composable AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visibleState = state,
        enter = enter,
        exit = exit,
        content = content
    )
}