package com.mark.orangetask.ui.news_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mark.orangetask.CompanyListingsScreen
import com.mark.orangetask.R
import com.mark.orangetask.ui.news_listings.NewsListingsViewModel
import com.mark.orangetask.ui.theme.OrangeTaskTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompanyInfoScreen(id = 3)
                }
            }
        
        }
      
    }
    @Composable
    fun CompanyInfoScreen(
        id: Int,
        viewModel: NewsListingsViewModel = hiltViewModel()
    ) {
        val state = viewModel.state
        if (state.isRefreshing == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.primaryDark))
                    .padding(16.dp)
            ) {
                state.news.get(3)?.let { article ->

                    Row() {
                        Box(
                            modifier = Modifier
                                .background(
                                    Color(0xFFFFFFFF),
                                    RoundedCornerShape(20)
                                )
                                .clip(RoundedCornerShape(20))
                                .width(60.dp)
                                .height(40.dp)
                        ) {
                            GlideImage(
                                imageModel = article.urlToImage.toString(),
                                contentScale = ContentScale.Crop,
                                circularReveal = CircularReveal(duration = 100),
                                alignment = Alignment.Center,

                                shimmerParams = ShimmerParams(
                                    baseColor = Color.White,
                                    highlightColor = Color.Gray,
                                    durationMillis = 500,
                                    dropOff = 0.55f,
                                    tilt = 20f

                                ), modifier = Modifier
                                    .width(40.dp)
                                    .height(30.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Column() {
                            Text(
                                text = article.title!!,
                                color= colorResource(R.color.white),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,


                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.End)

                                    .align(Alignment.CenterHorizontally)
                                    .padding(start = 30.dp, top = 10.dp)
                            )
                        }


                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .align(Alignment.End)
                            .fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = article.publishedAt.toString(),
                            fontStyle = FontStyle.Italic,
                            fontSize = 14.sp,
                            color= colorResource(R.color.white),

                            modifier = Modifier
                                .wrapContentWidth()
                                .weight(1f),
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Text(
                            text = " ${article.description} ",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color= colorResource(R.color.mainTextColor),

                            modifier = Modifier
                                .wrapContentWidth()
                                .weight(1f),
                            overflow = TextOverflow.Ellipsis
                        )

                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Text(
                            text = "Author ${article.author}",
                            fontSize = 18.sp,
                            color= colorResource(R.color.white),

                            modifier = Modifier
                                .wrapContentWidth()
                                .weight(1f),
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Text(
                            text = "Source: ${article.source}",
                            fontSize = 18.sp,
                            color= colorResource(R.color.white),

                            modifier = Modifier
                                .wrapContentWidth()
                                .weight(1f),
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Text(
                            text = "Go to Source: ${article.source.name}",
                            fontSize = 18.sp,
                            color= colorResource(R.color.white),

                            modifier = Modifier
                                .wrapContentWidth()
                                .weight(1f),
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else if (state.isRefreshing != null) {
//                    Text(
//                        text = state.error,
//                        color = MaterialTheme.colors.error
//                    )
            }
        }
    }
}