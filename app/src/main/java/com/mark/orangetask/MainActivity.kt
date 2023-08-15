package com.mark.orangetask

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.mark.orangetask.ui.news_listings.NewsItem
import com.mark.orangetask.ui.news_listings.NewsListingsViewModel
import com.mark.orangetask.ui.theme.OrangeTaskTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompanyListingsScreen()

                 }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyListingsScreen(
     viewModel: NewsListingsViewModel = hiltViewModel()
) {
    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.state.isRefreshing
    )
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {

            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
            ,
            placeholder = {
                Text(text = "Search...",)
                colorResource(id = R.color.white)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(

                focusedLabelColor = colorResource(id = R.color.white),
                cursorColor = colorResource(id = R.color.teal_700)
            ),
            maxLines = 1,
            singleLine = true
        )
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
            }
        ) {
            Column() {


                Row(modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(


                        modifier = Modifier
                            .padding(5.dp)
                            .background(
                                Color(0xFF282b2f),
                                RoundedCornerShape(20)
                            )
                            .clip(RoundedCornerShape(20))


                    ) {
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Log.e("listings screen",state.news.size.toString())

                    items(state.news.size) { i ->
                        val article = state.news[i]
                        NewsItem(

                            article = article,
                            id = 3

                        )
                        if (i < state.news.size) {
                            Divider(
                                modifier = Modifier.padding(
                                    horizontal = 16.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OrangeTaskTheme{
        CompanyListingsScreen()
        Greeting("Android")
    }
}