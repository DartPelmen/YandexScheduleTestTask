package com.ivankuznetsov.yandexscheduletesttask.ui.widget

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ivankuznetsov.yandexscheduletesttask.R

@Composable
fun ScreenTitle(modifier: Modifier, text: String){
    Text(stringResource(R.string.screeen_title))
}

