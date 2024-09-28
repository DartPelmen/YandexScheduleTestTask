package com.ivankuznetsov.yandexscheduletesttask.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.ivankuznetsov.yandexscheduletesttask.R

@Composable
fun DestinationsWidget(
    modifier: Modifier,
    startPoint: String,
    destination: String,
    onStartPointClicked:()->Unit,
    onDestinationClicked:()->Unit,
    onSwitchPoints: () -> Unit
) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Column {
            TextButton(
                onClick = {
                    onStartPointClicked()
                }
            ) {
                Text(text = startPoint)
            }
            TextButton(
                onClick = {
                    onDestinationClicked()
                }
            ) {
                Text(text = destination)
            }
        }
        IconButton(modifier = Modifier, onClick = onSwitchPoints) {
            Icon(
                modifier = Modifier,
                imageVector = ImageVector.vectorResource(id = R.drawable.switch_icon),
                contentDescription = stringResource(R.string.switch_text)
            )
        }
    }
}