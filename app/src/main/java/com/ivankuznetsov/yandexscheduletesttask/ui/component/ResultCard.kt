package com.ivankuznetsov.yandexscheduletesttask.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.ivankuznetsov.yandexscheduletesttask.R
import kotlin.math.max

@Composable
fun ResultCard(modifier: Modifier) {
    Row {
        Icon(
            modifier = Modifier.wrapContentWidth(),
            imageVector = ImageVector.vectorResource(id = R.drawable.airplane_svgrepo_com),
            contentDescription = "plane"
        )
        Column{
            Text(maxLines = 2, text = "TITLE")
            Text(maxLines = 1, text = "company")
            Text(maxLines = 1, text = "auto")
        }
        Column{
            Text(maxLines = 1, text = "date")
            Text(maxLines = 1, text = "time")
            Text(maxLines = 4, text = "place")
        }
        Column{
            Text(maxLines = 1, text = "duration")
        }
        Column{
            Text(maxLines = 1, text = "date")
            Text(maxLines = 1, text = "time")
            Text(maxLines = 4, text = "place")
        }
    }
}

@Preview
@Composable
fun ResultCardPreview(modifier: Modifier = Modifier) {
    ResultCard(modifier)
}