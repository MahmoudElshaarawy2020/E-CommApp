package com.example.e_commapp.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.e_commapp.R

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = false,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = if (selectedItem == index) colorResource(id = R.color.light_blue) else colorResource(id = R.color.light_grey)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 12.sp,
                        color = if (selectedItem == index) colorResource(id = R.color.light_blue) else Color.Gray
                    )
                }
            )
        }
    }
}