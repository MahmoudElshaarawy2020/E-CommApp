//package com.example.e_commapp.presentation.home
//
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun HorizontalSlider(modifier: Modifier = Modifier) {
//    HorizontalPager(
//        count = items?.size ?: 0,
//        state = pagerState
//    ) { page ->
//        // Define the content of each page here
//        SubcomposeAsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data(items?.get(page))
//                .crossfade(true)
//                .build(),
//            loading = {
//                CircularProgressIndicator(
//                    color = Color.LightGray,
//                    modifier = Modifier.padding(48.dp)
//                )
//            },
//            contentDescription = stringResource(R.string.product_thumbnail),
//            contentScale = ContentScale.Fit,
//            modifier = Modifier.height(260.dp)
//        )
//    }
//    Spa
//
//}