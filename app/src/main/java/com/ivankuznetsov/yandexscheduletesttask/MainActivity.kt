package com.ivankuznetsov.yandexscheduletesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ivankuznetsov.yandexscheduletesttask.ui.component.SearchForm
import com.ivankuznetsov.yandexscheduletesttask.ui.theme.YandexScheduleTestTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YandexScheduleTestTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchForm(modifier = Modifier)
                }
            }
        }
    }
}

