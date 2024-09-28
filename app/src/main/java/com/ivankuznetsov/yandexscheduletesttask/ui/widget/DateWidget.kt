package com.ivankuznetsov.yandexscheduletesttask.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ivankuznetsov.yandexscheduletesttask.R
import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime

@Composable
fun DateWidget(
    modifier: Modifier,
    currentTravelDate: LocalDate?,
    onTravelDateSelected: (LocalDate?) -> Unit
) {
    var needToShowDatePicker by rememberSaveable {
        mutableStateOf(false)
    }
    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val tomorrow = today.plus(DatePeriod(0, 0, 1))
    Row {
        if (needToShowDatePicker) {
            DatePickerModalInput(onDateSelected = {
                val date = it?.let { it1 ->
                    Instant.fromEpochMilliseconds(it1)
                        .toLocalDateTime(TimeZone.currentSystemDefault()).date
                }
                onTravelDateSelected(date)
            }) {
                needToShowDatePicker = false
            }
        }
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = (if (currentTravelDate == today) Color.Green else Color.Unspecified)
            ),
            onClick = {
                onTravelDateSelected(today)
            }) {
            Text(text = stringResource(R.string.today_text))
        }
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = (if (currentTravelDate == tomorrow) Color.Green else Color.Unspecified)
            ),
            onClick = {
                onTravelDateSelected(
                    Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date.plus(
                        DatePeriod(0, 0, 1)
                    )
                )

            }) {
            Text(text = stringResource(R.string.tomorrow_text))
        }
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = (if (currentTravelDate != null &&
                    currentTravelDate != today &&
                    currentTravelDate != tomorrow
                ) Color.Green else Color.Unspecified)
            ),
            onClick = {
                needToShowDatePicker = true
            }) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = stringResource(R.string.date_text))
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = stringResource(R.string.date_text)
                )
            }
        }
    }
}