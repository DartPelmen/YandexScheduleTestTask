package com.ivankuznetsov.yandexscheduletesttask.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ivankuznetsov.yandexscheduletesttask.R
import com.ivankuznetsov.yandexscheduletesttask.model.Suggestion
import com.ivankuznetsov.yandexscheduletesttask.viewmodel.SuggestionViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchDialog(modifier: Modifier,
                 startValue: String,
                 onClose: (Suggestion?) -> Unit) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        var searchPoint by rememberSaveable {
            mutableStateOf(startValue)
        }

        Scaffold(modifier = Modifier.padding(4.dp)) {innerPadding ->
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(innerPadding)) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(modifier = Modifier.align(Alignment.CenterVertically), text = stringResource(id = R.string.start_point_text))
                    IconButton(modifier = Modifier, onClick = {
                        onClose(null)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(id = R.string.close_text)
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(modifier = modifier.fillMaxWidth(), value = searchPoint, onValueChange = {
                        searchPoint = it
                    })
                    SuggestionList(modifier = Modifier, searchPoint = searchPoint, { onClose(it) })
                }

            }
        }
    }
}
