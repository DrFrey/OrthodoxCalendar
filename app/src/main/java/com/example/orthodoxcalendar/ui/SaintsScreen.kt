package com.example.orthodoxcalendar.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.orthodoxcalendar.domain.models.DayLocal
import com.ireward.htmlcompose.HtmlText
import com.example.orthodoxcalendar.R

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun SaintsScreen(
    saints: List<DayLocal.Saint>,
    navController: NavHostController,
//    onCardClicked: (DayLocal.Saint) -> Unit
    isVisible: Boolean
) {
    Log.d("___", "SaintsScreen launched")
    if (isVisible) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(saints) { saint ->
                saint.id?.let {
                    SaintCard(
                        saint = saint,
                        onCardClicked = {
                            navController.navigate(
                                "${MainDestinations.DETAILS_SCREEN}/${it.name}"
                            )
                        }
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun SaintCard(
    modifier: Modifier = Modifier,
    saint: DayLocal.Saint,
    onCardClicked: (DayLocal.Saint) -> Unit
) {
    Card(
        modifier = modifier
            .padding(all = 4.dp)
            .fillMaxWidth(),
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        onClick = {
            onCardClicked(saint)
            Log.d("___", "saint clicked; saint name = ${saint.name}")
        }
    ) {
        Row {
            when (saint.ideograph) {
                1 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_1),
                    contentDescription = null
                )
                2 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_2),
                    contentDescription = null
                )
                3 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_3),
                    contentDescription = null
                )
                4 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_4),
                    contentDescription = null
                )
                5 -> Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.ideograph_5),
                    contentDescription = null
                )
                else -> {}
            }
            HtmlText(
                text = saint.generatedText,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.body2
            )
        }
    }
}