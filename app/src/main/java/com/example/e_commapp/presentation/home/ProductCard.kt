package com.example.e_commapp.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commapp.R

@Composable
fun ProductCard(modifier: Modifier = Modifier) {
    //Adding font family
    val poppinsFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium),
        Font(R.font.poppins_semibold),
        Font(R.font.poppins_bold)
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(width = 140.dp, height = 230.dp)
            .border(
                BorderStroke(1.dp, color = colorResource(id = R.color.lighter_grey)),
                shape = RoundedCornerShape(16.dp)
            )
            .background(Color.White,shape = RoundedCornerShape(16.dp))
    ){
        Column(modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Image(
                painter = painterResource(id = R.drawable.yellow_shoes_img),
                contentDescription = null,
                modifier = Modifier.size(110.dp))
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp),
                text = "FS - Nike Air \n Max 270 React...",
                color = Color.Black,
                maxLines = 2,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontFamily = poppinsFamily
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp),
                text = "$299.45",
                color = colorResource(id = R.color.light_blue),
                maxLines = 2,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
                lineHeight = 21.sp,
                fontFamily = poppinsFamily
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 8.dp),
                text = "24% Off",
                color = Color.Red,
                maxLines = 2,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 10.sp,
                lineHeight = 15.sp,
                fontFamily = poppinsFamily
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    ProductCard()
}