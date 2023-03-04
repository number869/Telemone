package com.dotstealab.telemone.ui.screens.editor.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dotstealab.telemone.MainViewModel
import com.dotstealab.telemone.ui.theme.FullPaletteList

@Composable
fun PalettePopup(key: String, vm: MainViewModel, palette: FullPaletteList) {
	Surface(modifier = Modifier) {
		Column {
			Text(text = key)
			Row {
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_0)
						.clickable { vm.changeValue(key, palette.a1_0, "a1_0") }
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_10)
						.clickable { vm.changeValue(key, palette.a1_10, "a1_10")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_50)
						.clickable { vm.changeValue(key, palette.a1_50, "a1_50")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_100)
						.clickable { vm.changeValue(key, palette.a1_100, "a1_100")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_200)
						.clickable { vm.changeValue(key, palette.a1_200, "a1_200")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_300)
						.clickable { vm.changeValue(key, palette.a1_300, "a1_300")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_400)
						.clickable { vm.changeValue(key, palette.a1_400, "a1_400")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_500)
						.clickable { vm.changeValue(key, palette.a1_500, "a1_500")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_600)
						.clickable { vm.changeValue(key, palette.a1_600, "a1_600")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_700)
						.clickable { vm.changeValue(key, palette.a1_700, "a1_700")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_800)
						.clickable { vm.changeValue(key, palette.a1_800, "a1_800")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_900)
						.clickable { vm.changeValue(key, palette.a1_900, "a1_900")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a1_1000)
						.clickable { vm.changeValue(key, palette.a1_1000, "a1_1000")}
				)
			}

			Row {
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_0)
						.clickable { vm.changeValue(key, palette.a2_0, "a2_0") }
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_10)
						.clickable { vm.changeValue(key, palette.a2_10, "a2_10")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_50)
						.clickable { vm.changeValue(key, palette.a2_50, "a2_50")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_100)
						.clickable { vm.changeValue(key, palette.a2_100, "a2_100")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_200)
						.clickable { vm.changeValue(key, palette.a2_200, "a2_200")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_300)
						.clickable { vm.changeValue(key, palette.a2_300, "a2_300")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_400)
						.clickable { vm.changeValue(key, palette.a2_400, "a2_400")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_500)
						.clickable { vm.changeValue(key, palette.a2_500, "a2_500")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_600)
						.clickable { vm.changeValue(key, palette.a2_600, "a2_600")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_700)
						.clickable { vm.changeValue(key, palette.a2_700, "a2_700")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_800)
						.clickable { vm.changeValue(key, palette.a2_800, "a2_800")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_900)
						.clickable { vm.changeValue(key, palette.a2_900, "a2_900")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a2_1000)
						.clickable { vm.changeValue(key, palette.a2_1000, "a2_1000")}
				)
			}

			Row {
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_0)
						.clickable { vm.changeValue(key, palette.a3_0, "a3_0") }
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_10)
						.clickable { vm.changeValue(key, palette.a3_10, "a3_10")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_50)
						.clickable { vm.changeValue(key, palette.a3_50, "a3_50")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_100)
						.clickable { vm.changeValue(key, palette.a3_100, "a3_100")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_200)
						.clickable { vm.changeValue(key, palette.a3_200, "a3_200")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_300)
						.clickable { vm.changeValue(key, palette.a3_300, "a3_300")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_400)
						.clickable { vm.changeValue(key, palette.a3_400, "a3_400")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_500)
						.clickable { vm.changeValue(key, palette.a3_500, "a3_500")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_600)
						.clickable { vm.changeValue(key, palette.a3_600, "a3_600")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_700)
						.clickable { vm.changeValue(key, palette.a3_700, "a3_700")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_800)
						.clickable { vm.changeValue(key, palette.a3_800, "a3_800")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_900)
						.clickable { vm.changeValue(key, palette.a3_900, "a3_900")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.a3_1000)
						.clickable { vm.changeValue(key, palette.a3_1000, "a3_1000")}
				)
			}

			Row {
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_0)
						.clickable { vm.changeValue(key, palette.n1_0, "n1_0") }
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_10)
						.clickable { vm.changeValue(key, palette.n1_10, "n1_10")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_50)
						.clickable { vm.changeValue(key, palette.n1_50, "n1_50")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_100)
						.clickable { vm.changeValue(key, palette.n1_100, "n1_100")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_200)
						.clickable { vm.changeValue(key, palette.n1_200, "n1_200")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_300)
						.clickable { vm.changeValue(key, palette.n1_300, "n1_300")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_400)
						.clickable { vm.changeValue(key, palette.n1_400, "n1_400")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_500)
						.clickable { vm.changeValue(key, palette.n1_500, "n1_500")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_600)
						.clickable { vm.changeValue(key, palette.n1_600, "n1_600")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_700)
						.clickable { vm.changeValue(key, palette.n1_700, "n1_700")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_800)
						.clickable { vm.changeValue(key, palette.n1_800, "n1_800")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_900)
						.clickable { vm.changeValue(key, palette.n1_900, "n1_900")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n1_1000)
						.clickable { vm.changeValue(key, palette.n1_1000, "n1_1000")}
				)
			}

			Row {
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_0)
						.clickable { vm.changeValue(key, palette.n2_0, "n2_0") }
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_10)
						.clickable { vm.changeValue(key, palette.n2_10, "n2_10")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_50)
						.clickable { vm.changeValue(key, palette.n2_50, "n2_50")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_100)
						.clickable { vm.changeValue(key, palette.n2_100, "n2_100")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_200)
						.clickable { vm.changeValue(key, palette.n2_200, "n2_200")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_300)
						.clickable { vm.changeValue(key, palette.n2_300, "n2_300")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_400)
						.clickable { vm.changeValue(key, palette.n2_400, "n2_400")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_500)
						.clickable { vm.changeValue(key, palette.n2_500, "n2_500")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_600)
						.clickable { vm.changeValue(key, palette.n2_600, "n2_600")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_700)
						.clickable { vm.changeValue(key, palette.n2_700, "n2_700")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_800)
						.clickable { vm.changeValue(key, palette.n2_800, "n2_800")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_900)
						.clickable { vm.changeValue(key, palette.n2_900, "n2_900")}
				)
				Box(
					Modifier
						.size(26.dp)
						.background(palette.n2_1000)
						.clickable { vm.changeValue(key, palette.n2_1000, "n2_1000")}
				)
			}
		}
	}
}