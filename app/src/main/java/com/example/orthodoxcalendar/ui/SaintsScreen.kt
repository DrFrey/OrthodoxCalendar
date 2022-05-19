package com.example.orthodoxcalendar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.example.orthodoxcalendar.R
import com.example.orthodoxcalendar.data.storage.models.DayLocal
import com.ireward.htmlcompose.HtmlText

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun SaintsScreen(
    saints: List<DayLocal.Saint>,
    navController: NavHostController,
    isVisible: Boolean
) {
    if (isVisible) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = spacedBy(4.dp)
        ) {
            items(saints) { saint ->
                saint.id?.let {
                    SaintCard(
                        saint = saint,
                        onCardClicked = {
                            navController.navigate(
                                "${MainDestinations.DETAILS_SCREEN}/${DetailTypes.SAINT.name}/${saint.id}"
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
            .padding(horizontal = 4.dp, vertical = 0.dp)
            .fillMaxWidth(),
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (icon, text, info) = createRefs()
            val leftGuideline = createGuidelineFromStart(35.dp)

            when (saint.ideograph) {
                1 -> Image(
                    modifier = Modifier
                        .constrainAs(icon) {
                            start.linkTo(parent.start, 4.dp)
                            end.linkTo(text.start, 4.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .padding(horizontal = 4.dp),
                    alignment = Alignment.CenterStart,
                    painter = painterResource(R.drawable.ideograph_1),
                    contentDescription = null
                )
                2 -> Image(
                    modifier = Modifier
                        .constrainAs(icon) {
                            start.linkTo(parent.start, 4.dp)
                            end.linkTo(text.start, 4.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .padding(horizontal = 4.dp),
                    alignment = Alignment.CenterStart,
                    painter = painterResource(R.drawable.ideograph_2),
                    contentDescription = null
                )
                3 -> Image(
                    modifier = Modifier
                        .constrainAs(icon) {
                            start.linkTo(parent.start, 4.dp)
                            end.linkTo(text.start, 4.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .padding(horizontal = 4.dp),
                    alignment = Alignment.CenterStart,
                    painter = painterResource(R.drawable.ideograph_3),
                    contentDescription = null
                )
                4 -> Image(
                    modifier = Modifier
                        .constrainAs(icon) {
                            start.linkTo(parent.start, 4.dp)
                            end.linkTo(text.start, 4.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .padding(horizontal = 4.dp),
                    alignment = Alignment.CenterStart,
                    painter = painterResource(R.drawable.ideograph_4),
                    contentDescription = null
                )
                5 -> Image(
                    modifier = Modifier
                        .constrainAs(icon) {
                            start.linkTo(parent.start, 4.dp)
                            end.linkTo(text.start, 4.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                        .padding(horizontal = 4.dp),
                    alignment = Alignment.CenterStart,
                    painter = painterResource(R.drawable.ideograph_5),
                    contentDescription = null
                )
                else -> {}
            }
            HtmlText(
                text = saint.generatedText,
                modifier = Modifier
                    .padding(4.dp)
                    .constrainAs(text) {
                        start.linkTo(leftGuideline, 4.dp)
                        end.linkTo(info.start, 4.dp)
                        width = Dimension.fillToConstraints
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                style = MaterialTheme.typography.body1
            )
            IconButton(
                modifier = Modifier
                    .constrainAs(info) {
                        end.linkTo(parent.end, 4.dp)
                        top.linkTo(parent.top, 4.dp)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(horizontal = 4.dp),
                onClick = { onCardClicked(saint) }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "information"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSaintCard() {

}