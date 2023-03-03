package com.dotstealab.telemone.ui.screens.editor.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.dotstealab.telemone.MainViewModel
import com.dotstealab.telemone.ui.theme.FullPaletteList

@Composable
fun LoadFromSavedDialog(
	close: () -> Unit,
	vm: MainViewModel,
	palette: FullPaletteList,
	uuid: String
) {
	AlertDialog(
		onDismissRequest = { close() },
		confirmButton = {
			TextButton(
				onClick = {
					close()

					vm.setCurrentMapTo(
						uuid,
						loadTokens = false,
						palette,
						clearCurrentTheme = true
					)
				}
			) {
				Text("Load color values and clear current theme")
			}

			TextButton(
				onClick = {
					close()

					vm.setCurrentMapTo(
						uuid,
						loadTokens = false,
						palette,
						clearCurrentTheme = false
					)
				}
			) {
				Text("Load color values and  don't clear current theme")
			}
			TextButton(onClick = { close() }) {
				Text("Cancel")
			}
		},
		dismissButton = {
			TextButton(
				onClick = {
					close()

					vm.setCurrentMapTo(
						uuid,
						loadTokens = true,
						palette,
						clearCurrentTheme = true
					)
				}
			) {
				Text("Load colors from material color scheme tokens and clear current theme")
			}
			TextButton(
				onClick = {
					close()

					vm.setCurrentMapTo(
						uuid,
						loadTokens = true,
						palette,
						clearCurrentTheme = false
					)
				}
			) {
				Text("Load colors from material color scheme tokens and don't clear current theme")
			}
		}
	)
}