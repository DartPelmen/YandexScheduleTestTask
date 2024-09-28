package com.ivankuznetsov.yandexscheduletesttask.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ivankuznetsov.yandexscheduletesttask.model.Suggestion
import com.ivankuznetsov.yandexscheduletesttask.viewmodel.SuggestionViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SuggestionList(
    modifier: Modifier = Modifier,
    searchPoint: String,
    onItemSelected: (Suggestion)->Unit,
    suggestionViewModel: SuggestionViewModel = koinViewModel()
) {
    val suggestions by suggestionViewModel.getSuggestions(part = searchPoint)
        .collectAsState(initial = mutableListOf())

    LazyColumn {
        items(suggestions) {
            Text(
                modifier = Modifier.clickable {
                    onItemSelected(it)
                },
                text = it.fullName
            )
        }
    }
}