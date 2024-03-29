package com.number869.telemone.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.number869.decomposite.core.common.navigation.navController
import com.number869.decomposite.core.common.ultils.ContentType
import com.number869.decomposite.core.common.viewModel.viewModel
import com.number869.telemone.MainViewModel
import com.number869.telemone.ui.Destinations
import com.number869.telemone.ui.screens.main.components.DefaultThemesButtons


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
	val vm = viewModel<MainViewModel>()
	val navController = navController<Destinations>()

	LaunchedEffect(Unit) {
		if (vm.displayLightThemeUpdateChoiceDialog) navController.navigate(
			Destinations.GlobalDialogs.ThemeUpdateAvailable(true),
			ContentType.Overlay
		)

		if (vm.displayDarkThemeUpdateChoiceDialog) navController.navigate(
			Destinations.GlobalDialogs.ThemeUpdateAvailable(false),
			ContentType.Overlay
		)
	}

	Column(Modifier.fillMaxSize()) {
		var showMenu by rememberSaveable { mutableStateOf(false) }

		CenterAlignedTopAppBar(
			title = { Text(text = "Telemone") },
			actions = {
				IconButton(onClick = { showMenu = true }) {
					Icon(Icons.Filled.MoreVert, contentDescription = "Menu")
				}

				DropdownMenu(
					expanded = showMenu,
					onDismissRequest = { showMenu = false }
				) {
					if (vm.lightThemeCanBeUpdated) {
						DropdownMenuItem(
							text = { Text("Update default light theme") },
							onClick = {
								navController.navigate(
									Destinations.GlobalDialogs.ThemeUpdateAvailable(true),
									ContentType.Overlay
								)
								showMenu = false
							}
						)
					}

					if (vm.darkThemeCanBeUpdated) {
						DropdownMenuItem(
							text = { Text("Update default dark theme") },
							onClick = {
								navController.navigate(
									Destinations.GlobalDialogs.ThemeUpdateAvailable(false),
									ContentType.Overlay
								)
								showMenu = false
							}
						)
					}

					DropdownMenuItem(
						text = { Text("About") },
						onClick = {
							navController.navigate(Destinations.AboutScreen.About)
							showMenu = false
						}
					)
				}
			}
		)

		Column(
			Modifier
				.padding(24.dp)
				.weight(1f),
			verticalArrangement = Arrangement.SpaceAround,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			DefaultThemesButtons()

			OutlinedButton(onClick = { navController.navigate(Destinations.EditorScreen.Editor) }) {
				Text(text = "Go to theme editor")
			}
		}
	}
}