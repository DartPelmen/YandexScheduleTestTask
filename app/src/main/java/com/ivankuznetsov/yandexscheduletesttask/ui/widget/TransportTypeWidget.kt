package com.ivankuznetsov.yandexscheduletesttask.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ivankuznetsov.yandexscheduletesttask.R

@Composable
fun TransportTypeWidget(modifier: Modifier) {
    Row {
        Button(onClick = { }) {
            Text(text = stringResource(R.string.any_text))
        }
        Button(onClick = { }) {
            Text(text = "plane")
        }
        Button(onClick = { }) {
            Text(text = "train")
        }
        Button(onClick = { }) {
            Text(text = "tram")
        }
        Button(onClick = { }) {
            Text(text = "bus")
        }
    }
}