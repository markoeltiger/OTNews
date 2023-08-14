package com.mark.orangetask.ui.news_listings

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mark.orangetask.R
import com.mark.orangetask.domain.model.Article
import com.ramcosta.composedestinations.annotation.Destination
import com.skydoves.landscapist.glide.GlideImage
@Destination
@Composable
fun NewsItem(article: Article){
    Box(
        modifier = Modifier
            .padding(10.dp)

            .background(
                Color(0xFFFFFFFF),
                RoundedCornerShape(20)
            )
            .clip(RoundedCornerShape(20)),

        ) {
        Column() {
            com.skydoves.landscapist.glide.GlideImage(article.urlToImage)
            Log.e("article title", article.title)
            Text(
                text = article.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(10.dp)

            )

        }

    }

}
@Preview(showBackground = true)
@Composable
fun PerviewNewsItem(){
 }