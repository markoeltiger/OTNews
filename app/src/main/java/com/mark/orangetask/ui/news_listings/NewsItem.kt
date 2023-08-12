package com.mark.orangetask.ui.news_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

@Composable
fun NewsItem(){
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
            Image(painter = painterResource(id =  R.drawable.ic_launcher_background), contentDescription = "News image")

            Text(
                text = " News Title",
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
    NewsItem()
}