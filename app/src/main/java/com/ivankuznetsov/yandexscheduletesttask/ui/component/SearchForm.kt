package com.ivankuznetsov.yandexscheduletesttask.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SearchForm(modifier: Modifier){
    Column {
        Box {
            Column {
                TextField(value = "", onValueChange = {}, placeholder = {"откуда"})
                TextField(value = "", onValueChange = {}, placeholder = {"куда"})
            }
            Button(onClick = {  }) {
                Text(text = "switch")
            }
        }
        Row{
            Button(onClick = {  }) {
                Text(text = "today")
            }
            Button(onClick = {  }) {
                Text(text = "tomorrow")
            }
            Button(onClick = {  }) {
                Text(text = "date")
            }
        }
        Row{
            Button(onClick = {  }) {
                Text(text = "any")
            }
            Button(onClick = {  }) {
                Text(text = "plane")
            }
            Button(onClick = {  }) {
                Text(text = "train")
            }
            Button(onClick = {  }) {
                Text(text = "tram")
            }
            Button(onClick = {  }) {
                Text(text = "bus")
            }
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "search")
        }
    }
}

@Preview
@Composable
fun SearchFormPreview(modifier: Modifier = Modifier){
    SearchForm(modifier = modifier)
}