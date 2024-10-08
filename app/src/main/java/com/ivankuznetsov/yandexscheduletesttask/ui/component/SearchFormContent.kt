package com.ivankuznetsov.yandexscheduletesttask.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ivankuznetsov.yandexscheduletesttask.R
import com.ivankuznetsov.yandexscheduletesttask.ui.widget.DateWidget
import com.ivankuznetsov.yandexscheduletesttask.ui.widget.DestinationsWidget
import com.ivankuznetsov.yandexscheduletesttask.ui.widget.TransportTypeWidget
import kotlinx.datetime.LocalDate

@Composable
fun SearchFormContent(
    modifier: Modifier,
    startPoint: String,
    destination: String,
    date:LocalDate?,
    transport: String,
    onStartPointClicked: () -> Unit,
    onDestinationPointClicked:()->Unit,
    onSwitchPointClicked:()->Unit,
    onDateSelected:(LocalDate?)->Unit,
    onTransportSelected:(String)->Unit,
    onSearchClicked:()->Unit
) {
    DestinationsWidget(
        modifier = Modifier,
        startPoint,
        destination,
        onStartPointClicked,
        onDestinationPointClicked,
        onSwitchPointClicked)
    DateWidget(modifier = Modifier, date){
        onDateSelected(it)
    }
    TransportTypeWidget(modifier = Modifier,transport){onTransportSelected(it)}
    Button(modifier = Modifier.fillMaxWidth(),onClick = onSearchClicked) {
        Text(text = stringResource(R.string.search_text))
    }
}