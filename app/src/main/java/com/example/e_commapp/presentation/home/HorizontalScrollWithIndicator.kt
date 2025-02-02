import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.e_commapp.R

val imageList = mutableListOf(
    R.drawable.shoes_img,
    R.drawable.shoes_img,
    R.drawable.shoes_img,
    R.drawable.shoes_img,
    R.drawable.shoes_img
)

@Composable
fun HorizontalScrollWithIndicator(items: List<Int>) {
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(listState)
    val currentIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }

    LaunchedEffect(key1 = currentIndex) {
        while (true) {
            delay(3000)
            val nextIndex = if (currentIndex == items.size - 1) 0 else (currentIndex + 1)
            listState.animateScrollToItem(nextIndex)
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            state = listState,
            flingBehavior = flingBehavior,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items.size) { index ->
                Box(
                    modifier = Modifier
                        .size(width = 390.dp, height = 220.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = items[index]),
                        contentDescription = "Scroll image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            items.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = if (index == currentIndex)
                                colorResource(id = R.color.light_blue)
                            else
                                colorResource(R.color.light_grey),
                            shape = CircleShape
                        )
                )
                if (index < items.size - 1) {
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }
    }
}
