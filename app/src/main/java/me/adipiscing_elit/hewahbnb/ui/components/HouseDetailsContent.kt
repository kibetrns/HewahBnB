package me.adipiscing_elit.hewahbnb.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.data.model.Amenity
import me.adipiscing_elit.hewahbnb.data.model.House
import me.adipiscing_elit.hewahbnb.data.model.HouseReview
import me.adipiscing_elit.hewahbnb.util.formattedDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HouseDetailsContent(
    house: House,
    contentPadding: PaddingValues,
    onAddToPhoneIconClicked: () -> Unit,
    navigateToReviewsScreen:(houseId: String) -> Unit
) {

    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight()
    ) {

        item {
            //TODO("Image(s) slider goes here )
            
            Text(text = "Images slider goes here.")
        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {


                Column {
                    Text(text = stringResource(id = R.string.location))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = stringResource(id = R.string.location_icon),
                            tint = Color(0xFFD20000),
                            modifier = Modifier
                                .size(16.dp)
                        )

                        Text(
                            text = house.locationName,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                
                Text(
                    text = house.availability.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF00A900)
                )
            }
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                house.amenities.forEach { amenity: Amenity ->
                    item {
                        AmenityItem(amenity = amenity)
                    }
                }
            }
        }

        item {
            Column {
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = house.description,
                    maxLines = 11,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            navigateToReviewsScreen(house.houseId)
                        }
                    )
            ) {
                if (house.reviews.isEmpty()) {
                    Text(
                        text = "No Reviews Yet",
                        style = MaterialTheme.typography.bodySmall
                    )
                } else {

                    house.reviews.forEach { houseReview: HouseReview ->

                        //TODO("Use AsyncImage instead)
                        Image(
                            painter = houseReview.reviewer.profilePhoto,
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                        )
                    }

                    Column {

                        if (house.reviews.count() == 1) {
                            Text(text = "${house.reviews.count()} Review")
                        } else {
                            Text(text = "${house.reviews.count()} Reviews")
                        }

                        var dateTime: LocalDateTime? = null

                        house.reviews.map {
                            val date =
                                it.dateTimeReviewed.toLocalDateTime(timeZone = TimeZone.currentSystemDefault())

                            dateTime = date

                        }
                        Text(text = formattedDateTime(dateTime))
                    }

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
                        Text(text = "${house.rating}")
                    }
                }
            }
        }

        item {
            Card(
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.padding(horizontal = 32.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        //TODO("Use AsyncImage instead)
                        Image(
                            painter = house.owner.profilePhoto,
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(64.dp)
                                .clip(CircleShape)
                        )

                        Column {
                            Text(
                                text = house.owner.name,
                                style = MaterialTheme.typography.bodyLarge
                            )

                            Text(
                                text = "Owner ${house.name}",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                            )
                        }
                    }

                    Surface(
                        color = Color(0xFFAFAFAF),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        IconButton(
                            modifier = Modifier
                                .size(64.dp),
                            onClick = { onAddToPhoneIconClicked() }
                        ) {

                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = stringResource(id = R.string.phone_icon),
                                tint = Color(0xFFD20000),
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }

        item {
            Column {

                Text(
                    text = "Check-in",
                    style = MaterialTheme.typography.titleLarge
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable(
                                onClick = {} /*TODO("Handle this; the Calendar picker should be shown) */
                            )
                    ) {

                        Text(
                            text = formattedDateTime(
                                dateTime = Clock.System.now()
                                    .toLocalDateTime(timeZone = TimeZone.UTC)
                            ),
                            modifier = Modifier
                                .padding(end = 16.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = stringResource(id = R.string.calendarMonthIcon)
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable(
                                onClick = {} /*TODO("Handle this; the Time picker should be shown) */
                            )

                    ) {

                        Text(
                            text = formattedDateTime(
                                dateTime = Clock.System.now()
                                    .toLocalDateTime(timeZone = TimeZone.UTC)
                            ),
                            modifier = Modifier
                                .padding(end = 16.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.AccessTimeFilled,
                            contentDescription = stringResource(id = R.string.accessTimeIcon)
                        )
                    }

                }
            }

            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {

                Text(
                    text = "Check-out",
                    style = MaterialTheme.typography.titleLarge
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable(
                                onClick = {} /*TODO("Handle this; the Calendar picker should be shown) */
                            )
                    ) {

                        Text(
                            text = formattedDateTime(
                                dateTime = Clock.System.now()
                                    .toLocalDateTime(timeZone = TimeZone.UTC)
                            ),
                            modifier = Modifier
                                .padding(end = 16.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = stringResource(id = R.string.calendarMonthIcon)
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable(
                                onClick = {} /*TODO("Handle this; the Time picker should be shown) */
                            )
                    ) {

                        Text(
                            text = formattedDateTime(
                                dateTime = Clock.System.now()
                                    .toLocalDateTime(timeZone = TimeZone.UTC)
                            ),
                            modifier = Modifier
                                .padding(end = 16.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.AccessTimeFilled,
                            contentDescription = stringResource(id = R.string.accessTimeIcon)
                        )
                    }

                }
            }
        }

        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Column {
                    Text(text = "Total Amount")
                    Text(
                        text = "KES ${house.amount}",
                        color = Color(0xFFD20000),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }

                Button(
                    onClick = { /*TODO("Handle when want to make booking)*/ }
                ) {
                    Text(text = "Book Now")
                }

            }



        }
    }
}

@Composable
fun AmenityItem(
    amenity: Amenity
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFFD9D9D9))
                .size(32.dp)
        )
        Text(text = amenity.name)
    }
}