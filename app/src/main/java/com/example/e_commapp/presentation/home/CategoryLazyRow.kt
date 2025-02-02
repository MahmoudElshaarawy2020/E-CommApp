package com.example.e_commapp.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commapp.R

@Composable
fun RoundedItemBox(
    modifier: Modifier = Modifier,
    item: String
) {
    //Adding font family
    val poppinsFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium),
        Font(R.font.poppins_semibold),
        Font(R.font.poppins_bold)
    )
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(1.dp, color = colorResource(id = R.color.lighter_grey)),
                    shape = CircleShape
                )
                .background(Color.White, shape = CircleShape)
                .size(70.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.shirt_ic),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            fontFamily = poppinsFamily,
            text = item,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.light_grey)
        )
    }
}


@Composable
fun CategoryLazyRow() {
    val categories = listOf("Man Shift", "Dress", "Man Work", "Woman Bag", "Man Equipment")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories) { category ->
            RoundedItemBox(item = category)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryPreview() {
    CategoryLazyRow()
}