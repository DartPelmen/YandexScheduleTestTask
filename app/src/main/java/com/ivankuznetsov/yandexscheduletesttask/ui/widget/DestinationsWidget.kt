package com.ivankuznetsov.yandexscheduletesttask.ui.widget

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
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

    Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
            TextButton(modifier = Modifier.fillMaxWidth().align(Alignment.Start),
                onClick = {
                    onStartPointClicked()
                }
            ) {
                Text(modifier = Modifier.fillMaxWidth(),
                    text = startPoint,
                    textAlign = TextAlign.Start)
            }
            TextButton(modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onDestinationClicked()
                }
            ) {
                Text(modifier = Modifier.fillMaxWidth(),text = destination, textAlign = TextAlign.Start)
            }
        }
        IconButton(modifier = Modifier.wrapContentWidth(), onClick = onSwitchPoints) {
            Icon(
                modifier = Modifier,
                imageVector = ImageVector.vectorResource(id = R.drawable.switch_icon),
                contentDescription = stringResource(R.string.switch_text)
            )
        }
    }
}