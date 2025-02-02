package com.example.e_commapp.presentation.home

import HorizontalScrollWithIndicator
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commapp.R
import com.example.e_commapp.navigation.BottomNavItem
import com.example.e_commapp.navigation.BottomNavigationBar
import com.example.e_commapp.presentation.utils.CustomTextField
import imageList

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {


    val bottomNavItems = listOf(
        BottomNavItem("Home", R.drawable.home_nav_ic),
        BottomNavItem("Explore", R.drawable.search_nav_ic),
        BottomNavItem("Cart", R.drawable.cart_nav_ic),
        BottomNavItem("Offer", R.drawable.offer_nav_ic),
        BottomNavItem("Account", R.drawable.profile_nav_ic)
    )
    //Adding font family
    val poppinsFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_medium),
        Font(R.font.poppins_semibold),
        Font(
            R.font.poppins_bold
        )
    )
    var searchQuery by remember { mutableStateOf("") }
    val isFieldFocused by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableIntStateOf(0) }


    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavItems,
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Spacer(modifier = modifier.size(48.dp))

            Row(
                modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp),
                verticalAlignment = CenterVertically,
            ) {
                CustomTextField(
                    width = 260,
                    height = 55,
                    label = stringResource(id = R.string.search_product),
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    focusedBorderColor = colorResource(id = R.color.light_blue),
                    unfocusedBorderColor = colorResource(id = R.color.lighter_grey),
                    cursorColor = colorResource(id = R.color.light_grey),
                    leadingIcon = R.drawable.search_ic,
                    isFocused = isFieldFocused
                )
                Spacer(modifier = modifier.size(20.dp))
                Icon(
                    modifier = modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.favorite_ic),
                    contentDescription = "Favorite",
                    tint = colorResource(id = R.color.light_grey)
                )
                Spacer(modifier = modifier.size(20.dp))
                Icon(
                    modifier = modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "Notification",
                    tint = colorResource(id = R.color.light_grey)
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                item {
                    HorizontalScrollWithIndicator(items = imageList)
                }
                item {
                    Spacer(modifier = modifier.size(24.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.category),
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            color = Color.Black,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = stringResource(id = R.string.More_category),
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.light_blue),
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                    }
                }
                item {
                    Spacer(modifier = modifier.size(16.dp))
                    CategoryLazyRow()
                }
                item {
                    Spacer(modifier = modifier.size(24.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.flash_sale),
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            color = Color.Black,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = stringResource(id = R.string.see_more),
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.light_blue),
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    LazyRow(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(10) {
                            ProductCard()
                        }
                    }
                }
                item {
                    Spacer(modifier = modifier.size(24.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.mega_sale),
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            color = Color.Black,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = stringResource(id = R.string.see_more),
                            fontFamily = poppinsFamily,
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.light_blue),
                            lineHeight = 21.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    LazyRow(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(10) {
                            ProductCard()
                        }
                    }
                    Spacer(modifier = modifier.size(16.dp))
                }
                item {
                    Image(
                        painter = painterResource(id = R.drawable.shoes_img),
                        contentDescription = "Scroll image",
                        modifier = Modifier
                            .fillMaxSize()
                            .size(width = 390.dp, height = 220.dp)
                    )
                    Spacer(modifier = modifier.size(16.dp))
                }
                item {
                    Spacer(modifier = modifier.size(16.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(600.dp)
                            .padding(16.dp)
                    ) {
                        items(10) {
                            ProductCard(modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
        }
    }
}