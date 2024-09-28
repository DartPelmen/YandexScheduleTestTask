package com.ivankuznetsov.yandexscheduletesttask.ui.util

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
object FutureOrPresentSelectableDates: SelectableDates {
     override fun isSelectableDate(utcTimeMillis: Long): Boolean {
        return utcTimeMillis >= System.currentTimeMillis()
    }

     override fun isSelectableYear(year: Int): Boolean {
        return year >= Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year
    }

}