package com.slideindex.app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slideindex.app.R
import com.slideindex.app.data.AppInfo
import com.slideindex.app.data.AppListItem
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.util.toSafeImageBitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun IndexPanelScreen(
    side: PanelSide,
    items: List<AppListItem>,
    flatApps: List<AppInfo>,
    searchQuery: String,
    availableLetters: List<Char>,
    isLoading: Boolean,
    panelOpacity: Float,
    onSearchChange: (String) -> Unit,
    onAppClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    var highlightedLetterIndex by remember { mutableIntStateOf(-1) }

    val panelShape = if (side == PanelSide.LEFT) {
        RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp)
    } else {
        RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp)
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        shape = panelShape,
        color = MaterialTheme.colorScheme.surface.copy(alpha = panelOpacity),
        tonalElevation = 6.dp,
        shadowElevation = 12.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            SearchBar(
                query = searchQuery,
                onQueryChange = onSearchChange,
                modifier = Modifier.padding(bottom = 12.dp),
            )

            when {
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        LoadingContent(message = stringResource(R.string.loading))
                    }
                }
                searchQuery.isNotBlank() && flatApps.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(stringResource(R.string.no_apps))
                    }
                }
                else -> {
                    Row(modifier = Modifier.fillMaxSize()) {
                        if (side == PanelSide.RIGHT) {
                            AlphabetRail(
                                letters = availableLetters,
                                highlightedIndex = highlightedLetterIndex,
                                onLetterSelected = { letter ->
                                    val index = items.indexOfFirst {
                                        it is AppListItem.Header && it.letter == letter
                                    }
                                    if (index >= 0) {
                                        highlightedLetterIndex = availableLetters.indexOf(letter)
                                    }
                                },
                                onDragLetter = { letter ->
                                    highlightedLetterIndex = availableLetters.indexOf(letter)
                                },
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(28.dp),
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                        }

                        Box(modifier = Modifier.weight(1f)) {
                            LazyColumn(
                                state = listState,
                                modifier = Modifier.fillMaxSize(),
                            ) {
                                if (searchQuery.isNotBlank()) {
                                    items(flatApps.size, key = { flatApps[it].packageName }) { index ->
                                        val app = flatApps[index]
                                        AppRow(
                                            app = app,
                                            segmentIndex = index,
                                            segmentCount = flatApps.size,
                                            onClick = { onAppClick(app) },
                                        )
                                    }
                                } else {
                                    items(items, key = { item ->
                                        when (item) {
                                            is AppListItem.Header -> "h_${item.letter}"
                                            is AppListItem.App -> item.info.packageName
                                        }
                                    }) { item ->
                                        when (item) {
                                            is AppListItem.Header -> SectionHeader(item.letter)
                                            is AppListItem.App -> AppRow(
                                                app = item.info,
                                                segmentIndex = 0,
                                                segmentCount = 1,
                                                onClick = { onAppClick(item.info) },
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        if (side == PanelSide.LEFT) {
                            Spacer(modifier = Modifier.width(4.dp))
                            AlphabetRail(
                                letters = availableLetters,
                                highlightedIndex = highlightedLetterIndex,
                                onLetterSelected = { letter ->
                                    val index = items.indexOfFirst {
                                        it is AppListItem.Header && it.letter == letter
                                    }
                                    if (index >= 0) {
                                        highlightedLetterIndex = availableLetters.indexOf(letter)
                                    }
                                },
                                onDragLetter = { letter ->
                                    highlightedLetterIndex = availableLetters.indexOf(letter)
                                },
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(28.dp),
                            )
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(highlightedLetterIndex, availableLetters, items) {
        if (highlightedLetterIndex < 0 || searchQuery.isNotBlank()) return@LaunchedEffect
        val letter = availableLetters.getOrNull(highlightedLetterIndex) ?: return@LaunchedEffect
        val index = items.indexOfFirst { it is AppListItem.Header && it.letter == letter }
        if (index >= 0) {
            listState.scrollToItem(index)
        }
    }
}

@Composable
private fun SectionHeader(letter: Char) {
    Text(
        text = letter.toString(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 4.dp),
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        color = MaterialTheme.colorScheme.primary,
    )
}

@Composable
private fun AppRow(
    app: AppInfo,
    segmentIndex: Int,
    segmentCount: Int,
    onClick: () -> Unit,
) {
    Md3PickerListRow(
        segmentIndex = segmentIndex,
        segmentCount = segmentCount,
        title = app.label,
        selected = false,
        onClick = onClick,
        leadingContent = { Md3PickerAppLeading(app) },
    )
}

@Composable
private fun AlphabetRail(
    letters: List<Char>,
    highlightedIndex: Int,
    onLetterSelected: (Char) -> Unit,
    onDragLetter: (Char) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (letters.isEmpty()) return

    Column(
        modifier = modifier
            .pointerInput(letters) {
                detectVerticalDragGestures(
                    onDragStart = { offset ->
                        val index = ((offset.y / size.height) * letters.size)
                            .toInt()
                            .coerceIn(0, letters.lastIndex)
                        onDragLetter(letters[index])
                    },
                    onVerticalDrag = { change, _ ->
                        change.consume()
                        val index = ((change.position.y / size.height) * letters.size)
                            .toInt()
                            .coerceIn(0, letters.lastIndex)
                        onDragLetter(letters[index])
                    },
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        letters.forEachIndexed { index, letter ->
            val selected = index == highlightedIndex
            Text(
                text = letter.toString(),
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        if (selected) {
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                        } else {
                            MaterialTheme.colorScheme.surface.copy(alpha = 0f)
                        },
                    )
                    .clickable { onLetterSelected(letter) }
                    .padding(horizontal = 4.dp, vertical = 1.dp),
                fontSize = 11.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                color = if (selected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f)
                },
            )
        }
    }
}
