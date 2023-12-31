package me.adipiscing_elit.hewahbnb.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.data.model.House
import me.adipiscing_elit.hewahbnb.data.model.HouseReview
import me.adipiscing_elit.hewahbnb.data.model.RatingScore
import me.adipiscing_elit.hewahbnb.util.formattedDateTime

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReviewsScreenContent(
    contentPadding: PaddingValues,
    house: House,
    ratingScore: RatingScore,
    reviewDescription: String,
    onReviewDescriptionValueChange: (String) -> Unit,
    onRatingScoreSelected: (RatingScore) -> Unit,
    onPostReviewBtnClicked: () -> Unit

) {
    LazyColumn(
            contentPadding = contentPadding,
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {
        item {

            Box() {

                Column(
                    modifier = Modifier
                ) {

                    Text(
                        text = "Review",
                        style = MaterialTheme.typography.titleLarge
                    )

                    TextField(
                        placeholder = { Text("Type the review") },
                        value = reviewDescription,
                        onValueChange = onReviewDescriptionValueChange,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )

                    RatingScoreDropDown(
                        ratingScore = ratingScore,
                        onRatingScoreSelected = onRatingScoreSelected
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
,
                        ) {

                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFFF5722),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clickable(
                                    onClick = onPostReviewBtnClicked
                                )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Send,
                                    contentDescription = stringResource(id = R.string.sendIcon),
                                    tint = Color(0xFFFF5722),
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                )
                                Text(
                                    text = "Post Review",
                                    color = Color(0xFFFF5722),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            house.reviews.forEach { houseReview: HouseReview ->
                ReviewItem(houseReview = houseReview)
            }
        }

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReviewItem(
    houseReview: HouseReview
) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                //TODO("Use AsyncImage instead)
                Image(
                    painter = houseReview.reviewer.profilePhoto,
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )

                Text(text = houseReview.reviewer.fullName)
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = formattedDateTime(
                        houseReview.dateTimeReviewed.toLocalDateTime(timeZone = TimeZone.UTC)
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        tint = Color(0xFFFFD600),
                        contentDescription = stringResource(id = R.string.star_icon),
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Text(text = "${houseReview.ratingScore.score}")
                }
            }
        }

        Text(
            text = houseReview.reviewDescription,
            maxLines = 7,
            overflow = TextOverflow.Ellipsis
        )
    }
}