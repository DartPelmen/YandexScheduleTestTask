package com.ivankuznetsov.yandexscheduletesttask.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ivankuznetsov.yandexscheduletesttask.R
import com.ivankuznetsov.yandexscheduletesttask.ui.util.SearchFormContentType
import kotlinx.datetime.LocalDate


@Composable
fun SearchForm(modifier: Modifier) {
    var startPoint by rememberSaveable {
        mutableStateOf("")
    }
    var destination by rememberSaveable {
        mutableStateOf("")
    }
    var currentDate by rememberSaveable {
        mutableStateOf<LocalDate?>(null)
    }
    var currentContent by rememberSaveable {
        mutableStateOf(SearchFormContentType.CONTENT)
    }
    Column {
        when(currentContent){
            SearchFormContentType.CONTENT -> {
                SearchFormContent(modifier = Modifier,
                    startPoint = startPoint.ifBlank { stringResource(id = R.string.start_point_text) },
                    destination = destination.ifBlank { stringResource(id = R.string.destination_point_text) },
                    date = currentDate,
                    onStartPointClicked = {
                        currentContent = SearchFormContentType.START_DIALOG
                    },
                    onDestinationPointClicked = {
                        currentContent = SearchFormContentType.DESTINATION_DIALOG
                    },
                    onSwitchPointClicked = {
                        startPoint = destination.also {
                            destination = startPoint
                        }
                    },
                    onDateSelected = {currentDate = it},
                    onSearchClicked = {}
                    )
            }
            SearchFormContentType.START_DIALOG -> {
                SearchDialog(modifier = Modifier, startValue = startPoint) {
                    startPoint = it
                    currentContent = SearchFormContentType.CONTENT
                }
            }
            SearchFormContentType.DESTINATION_DIALOG -> {
                SearchDialog(modifier = Modifier, startValue = destination) {
                    destination = it
                    currentContent = SearchFormContentType.CONTENT
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchFormPreview(modifier: Modifier = Modifier) {
    SearchForm(modifier = modifier)
}