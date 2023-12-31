package me.adipiscing_elit.hewahbnb.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import me.adipiscing_elit.hewahbnb.data.model.House
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.data.model.Amenity
import me.adipiscing_elit.hewahbnb.data.model.Availability
import me.adipiscing_elit.hewahbnb.data.model.FurnishType
import me.adipiscing_elit.hewahbnb.data.model.HouseBooking
import me.adipiscing_elit.hewahbnb.data.model.HouseOwner
import me.adipiscing_elit.hewahbnb.data.model.HouseType
import me.adipiscing_elit.hewahbnb.data.model.Location
import me.adipiscing_elit.hewahbnb.data.model.PayFrequency
import kotlin.time.Duration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularHouseCard(
    house: House,
    isFavorite: Boolean,
    onAddToFavouritesClicked: () -> Unit,
    navigateToHouseDetailsScreen: (houseId: String) -> Unit
) {

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 0.dp)
                .width(width = 300.dp,)
                .background(
                    color = Color.Unspecified,
                    shape = MaterialTheme.shapes.medium.copy(
                        bottomEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        topStart = CornerSize(8.dp)
                    ),
                )
                .clickable(onClick = {
                    navigateToHouseDetailsScreen(house.houseId)
                })
            ,
        ) {
            HouseImageContainer(
                house = house,
                isFavorite = isFavorite,
                modifier = Modifier
                    .fillMaxWidth(),
                onAddToFavouritesClicked = onAddToFavouritesClicked
            )

            //TODO("have this reflect the design more; rouded corner etc")

            Column(
                modifier = Modifier
                    .border(BorderStroke(width = 1.dp, color = Color.Black))

            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = house.name,
                            style = MaterialTheme.typography.titleMedium,
                        )

                        Row {
                            Icon(
                                imageVector = Icons.Default.Star,
                                tint = Color(0xFFFFD600),
                                contentDescription = stringResource(id = R.string.ratingScore)
                            )
                            Text(text = "${house.rating}")
                        }
                    }

                    Spacer(
                        Modifier
                            .height(8.dp)
                            .padding(8.dp)
                    )

                    Text(text = house.locationName, style = MaterialTheme.typography.labelLarge)

                    Spacer(
                        Modifier
                            .height(8.dp)
                            .padding(8.dp)
                    )

                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                    )

                    Spacer(
                        Modifier
                            .height(8.dp)
                            .padding(8.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = stringResource(id = R.string.location_icon),
                                tint = Color(0xFFD20000),
                                modifier = Modifier
                                    .size(16.dp)
                            )
                            //TODO("Dynamically have this calculated)
                            Text(
                                text = "2KM From Your Location",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                        Text(
                            text = "KES ${house.amount}",
                            color = Color(0xFFF82500),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
}

@SuppressLint("SuspiciousIndentation")
@Preview(name = "HouseImagePreview", showBackground = true, showSystemUi = true)
@Composable
fun pPopularHouseCard() {

    val house = House(
        houseId = "CsmVXCXDqf1",
        images = listOf(painterResource(id = R.drawable.neon2)),
        name = "Cozy Cottage",
        locationName = "Serene Village",
        location = Location(latitude = 40.0, longitude = -30.0),
        distFrmMe = 10.5,
        rating = 4,
        amount = 1200.0,
        payFrequency = PayFrequency.MONTHLY,
        availability = Availability.AVAILABLE,
        description = "A beautiful cottage in a peaceful village.",
        owner = HouseOwner(
            name = "John Doe",
            properties = emptyList(),
            email = "john@example.com",
            mobileNumber = "+123456789",
            profilePhoto = painterResource(id = R.drawable.dp_4)
        ),  // Assuming no reviews initially.
        reviews = emptyList(),
        amenities = listOf(
            Amenity("WiFi", "High-speed internet connection"),
            Amenity("Parking", "Private parking space"),
        ),
        houseType = HouseType.COTTAGE,
        roomCount = 2,
        bathroomsCount = 1,
        size = 80.0,
        furnishType = FurnishType.FULLYFURNISHED,
        houseBooking = HouseBooking(
            bookingId = "booking123",
            checkIn = Clock.System.now(),
            checkOut = Clock.System.now().plus(Duration.parse("86400")),
            totalAmount = 1200,
            customerId = "customer123",
            houseOwnerId = "owner123"
        )
    )

        PopularHouseCard(
            house = house,
            isFavorite = true,
            onAddToFavouritesClicked = {},
            navigateToHouseDetailsScreen = {}
        )
}