package com.number869.telemone.ui.screens.editor.components.new

import android.content.Context
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShortText
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.number869.telemone.LoadedTheme
import com.number869.telemone.MainViewModel
import com.number869.telemone.ui.Screens
import com.number869.telemone.ui.theme.FullPaletteList
import com.number869.telemone.ui.theme.fullPalette
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun EditorTopAppBar(
	topAppBarState: TopAppBarScrollBehavior,
	navController: NavController,
	vm: MainViewModel,
	mappedValues: () -> LoadedTheme,
	mappedValuesAsList: () -> List<Pair<String, Pair<String, Color>>>
) {
	val context = LocalContext.current
	val palette = fullPalette()
	var showingClearBeforeLoadDialog by remember { mutableStateOf(false) }
	val pickedFileUriState = remember { mutableStateOf<Uri?>(null) }

	var searchbarVisible by remember { mutableStateOf(false) }

	// stuff for loading files.
	// this one is used when pressing the "clear" button
	val launcherThatClears = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.OpenDocument()
	) { result ->
		pickedFileUriState.value = result

		result?.let { uri ->
			vm.loadThemeFromFile(context, uri, palette, true)
		}
	}
	// this one is used when pressing the "leave as is" button
	val launcherThatDoesnt = rememberLauncherForActivityResult(
		contract = ActivityResultContracts.OpenDocument()
	) { result ->
		pickedFileUriState.value = result

		result?.let { uri ->
			vm.loadThemeFromFile(context, uri, palette, false)
		}
	}

	Box(
		Modifier.fillMaxWidth(),
		contentAlignment = Alignment.TopCenter
	) {
		AnimatedVisibility(
			!searchbarVisible,
			enter = fadeIn() + slideInVertically(),
			exit = fadeOut() + slideOutVertically()
		) {
			TheAppBar(
				navController,
				showSearchbar = { searchbarVisible = true },
				showClearBeforeLoadDialog = { showingClearBeforeLoadDialog = true },
				context,
				palette,
				vm,
				topAppBarState
			)
		}

		AnimatedVisibility(
			searchbarVisible,
			enter = fadeIn() + slideInVertically(),
			exit = fadeOut() + slideOutVertically()
		) {
			TheSearchbar(
				mappedValues = mappedValues ,
				mappedValuesAsList = mappedValuesAsList,
				hideSearchbar = { searchbarVisible = false },
				vm,
				palette
			)
		}
	}

	// Dialog that asks if the user wants to clear current theme
	// before loading one from file
	AnimatedVisibility(
		visible = showingClearBeforeLoadDialog,
		enter = expandVertically(),
		exit = shrinkVertically()
	) {
		ClearBeforeLoadDialog(
			{ showingClearBeforeLoadDialog = false },
			{
				showingClearBeforeLoadDialog = false
				vm.saveCurrentTheme(context)
				launcherThatClears.launch(arrayOf("*/*"))
			},
			{
				showingClearBeforeLoadDialog = false
				vm.saveCurrentTheme(context)
				launcherThatDoesnt.launch(arrayOf("*/*"))
			}
		)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TheAppBar(
	navController: NavController,
	showSearchbar: () -> Unit,
	showClearBeforeLoadDialog: () -> Unit,
	context: Context,
	palette: FullPaletteList,
	vm: MainViewModel,
	topAppBarState: TopAppBarScrollBehavior
) {
	var showMenu by remember { mutableStateOf(false) }
	var isShowingTapToSearchText by remember { mutableStateOf(false) }

	// switch texts every 3 seconds
	LaunchedEffect(isShowingTapToSearchText, Unit) {
		delay(3000)
		isShowingTapToSearchText = !isShowingTapToSearchText
	}

	TopAppBar(
		navigationIcon = {
			IconButton(onClick = { navController.popBackStack() }) {
				Icon(Icons.Default.ArrowBack, contentDescription = "Back")
			}
		},
		title = {
			AnimatedVisibility(
				!isShowingTapToSearchText,
				modifier = Modifier.clickable { showSearchbar() },
				enter = fadeIn(),
				exit = fadeOut()
			) {
				Text("Theme Editor")
			}
			AnimatedVisibility(
				isShowingTapToSearchText,
				modifier = Modifier.clickable { showSearchbar() },
				enter = fadeIn(),
				exit = fadeOut()
			) {
				Text("Tap to search")
			}
		},
		actions = {
			IconButton(onClick = { vm.exportCustomTheme(context) }) {
				Icon(Icons.Default.Upload, contentDescription = "Export current theme")
			}
			IconButton(onClick = { vm.saveCurrentTheme(context) }) {
				Icon(Icons.Default.Save, contentDescription = "Save current theme")
			}
			Box {
				IconButton(onClick = { showMenu = true }) {
					Icon(Icons.Default.MoreVert, contentDescription = "Options")
				}

				DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
					DropdownMenuItem(
						text = { Text(text = "Reset current theme") },
						onClick = { vm.resetCurrentTheme(context) },
						leadingIcon = { Icon(Icons.Default.Refresh, contentDescription = "Reset current theme") }
					)
					DropdownMenuItem(
						text = { Text(text = "Load stock light theme") },
						onClick = { vm.loadStockLightTheme(palette, context) },
						leadingIcon = { Icon(Icons.Default.LightMode, contentDescription = "Load stock light theme") }
					)
					DropdownMenuItem(
						text = { Text(text = "Load stock dark theme") },
						onClick = { vm.loadStockDarkTheme(palette, context) },
						leadingIcon = { Icon(Icons.Default.DarkMode, contentDescription = "Load stock dark theme") }
					)
					DropdownMenuItem(
						text = { Text(text = "Show values") },
						onClick = {
							navController.navigate(Screens.ThemeValuesScreen.route)
							showMenu = false
						},
						leadingIcon = { Icon(Icons.Default.ShortText, contentDescription = "Show values") }
					)
					DropdownMenuItem(
						text = { Text(text = "Load default light theme") },
						onClick = { vm.loadDefaultLightTheme(palette, context) },
						leadingIcon = { Icon(Icons.Default.LightMode, contentDescription = "Load default light theme") }
					)
					DropdownMenuItem(
						text = { Text(text = "Load default dark theme") },
						onClick = { vm.loadDefaultDarkTheme(palette, context) },
						leadingIcon = { Icon(Icons.Default.DarkMode, contentDescription = "Load default dark theme") }
					)
					DropdownMenuItem(
						text = { Text(text = "Load theme from file") },
						onClick = { showClearBeforeLoadDialog(); showMenu = false },
						leadingIcon = { Icon(Icons.Default.UploadFile, contentDescription = "Load default dark theme") }
					)
				}
			}
		},
		scrollBehavior = topAppBarState
	)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun TheSearchbar(
	mappedValues: () -> LoadedTheme,
	mappedValuesAsList: () -> List<Pair<String, Pair<String, Color>>>,
	hideSearchbar: () -> Unit,
	vm: MainViewModel,
	palette: FullPaletteList
) {
	var searchQuery by remember { mutableStateOf("") }
	val searchQueryIsEmpty by remember { derivedStateOf { searchQuery == "" } }
	val searchedThings by remember {
		derivedStateOf {
			mappedValuesAsList().filter {
				it.first.contains(searchQuery, true)
						||
						it.second.first.contains(searchQuery, true)
			}
		}
	}

	SearchBar(
		query = searchQuery,
		onQueryChange = { searchQuery = it },
		onSearch = {  }, // it desperately wants me to keep this line
		placeholder = { Text(text = "Search in current theme") },
		leadingIcon = { Icon(Icons.Default.Search, "Search")},
		trailingIcon = {
			AnimatedVisibility(
				visible = searchQueryIsEmpty,
				enter = fadeIn(),
				exit = fadeOut()
			) {
				IconButton(onClick = { hideSearchbar() }) {
					Icon(Icons.Default.ArrowUpward, "Hide searchbar")
				}
			}

			AnimatedVisibility(
				visible = !searchQueryIsEmpty,
				enter = fadeIn(),
				exit = fadeOut()
			) {
				IconButton(onClick = { searchQuery = "" }) {
					Icon(Icons.Default.Clear, "Clear search")
				}
			}
		},
		active = !searchQueryIsEmpty,
		onActiveChange = {  }
	) {
		// clears search when back button is pressed.
		// its here because it doesnt work if i put it
		// beside the other back handler at the top
		// of this composable
		BackHandler(!searchQueryIsEmpty) {
			searchQuery = ""
		}

		AnimatedVisibility(
			visible = !searchQueryIsEmpty,
			enter = fadeIn(),
			exit = fadeOut()
		) {
			LazyColumn(
				contentPadding = PaddingValues(
					top = 8.dp,
					bottom = 4.dp + WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
				),
				verticalArrangement = spacedBy(4.dp)
			) {
				itemsIndexed(searchedThings) { index, uiElementData ->
					ElementColorItem(
						Modifier
							.padding(horizontal = 16.dp)
							.animateItemPlacement(),
						uiElementData = uiElementData,
						vm = vm,
						index = index,
						themeMap = mappedValues(),
						lastIndexInList = mappedValuesAsList().lastIndex,
						palette = palette,
					)
				}
			}
		}
	}
}