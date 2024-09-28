package com.ivankuznetsov.yandexscheduletesttask.ui.widget

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivankuznetsov.yandexscheduletesttask.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransportTypeWidget(
    modifier: Modifier,
    selectedTransport: String,
    onChangeSelectedTransport: (String) -> Unit
) {


    val transports = listOf(
        stringResource(id = R.string.any_text),
        stringResource(R.string.suburban_text), stringResource(R.string.train_text),
        stringResource(R.string.plane_text), stringResource(R.string.bus_text)
    )
    SingleChoiceSegmentedButtonRow {
        SegmentedButton(
            selected = selectedTransport == transports[0],
            onClick = { onChangeSelectedTransport(transports[0]) },
            shape = SegmentedButtonDefaults.itemShape(index = 0, count = 5),
            label = { Text(fontSize = 12.sp, text = transports[0]) }
        )
        SegmentedButton(
            selected = selectedTransport == transports[1],
            onClick = { onChangeSelectedTransport(transports[1]) },
            shape = SegmentedButtonDefaults.itemShape(index = 1, count = 5),
            label = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.train_svgrepo_com),
                    contentDescription = transports[1]
                )
            }
        )
        SegmentedButton(
            selected = selectedTransport == transports[2],
            onClick = { onChangeSelectedTransport(transports[2]) },
            shape = SegmentedButtonDefaults.itemShape(index = 2, count = 5),

            label = {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.steam_locomotive_zwloiad1vjep),
                    contentDescription = transports[2]
                )

            }
        )

        SegmentedButton(
            selected = selectedTransport == transports[3],
            onClick = { onChangeSelectedTransport(transports[3]) },
            shape = SegmentedButtonDefaults.itemShape(index = 3, count = 5),

            label = {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.airplane_svgrepo_com),
                    contentDescription = transports[3]
                )

            }
        )

        SegmentedButton(
            selected = selectedTransport == transports[4],
            onClick = { onChangeSelectedTransport(transports[4]) },
            shape = SegmentedButtonDefaults.itemShape(index = 4, count = 5),

            label = {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.bus_svgrepo_com),
                    contentDescription = transports[4]
                )

            }
        )
    }
}