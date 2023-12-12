package me.adipiscing_elit.hewahbnb.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
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
import me.adipiscing_elit.hewahbnb.ui.theme.HewahBnBTheme
import kotlin.time.Duration

@Composable
fun PopularHouseCard(
    house: House,
    isFavorite: Boolean,
    onAddToFavouritesClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(
            color = Color.Unspecified,
            shape = MaterialTheme.shapes.medium.copy(
                bottomEnd = CornerSize(8.dp),
                bottomStart = CornerSize(8.dp),
                topEnd = CornerSize(8.dp),
                topStart = CornerSize(8.dp)
            )
        ),
    ) {
        HouseImageContainer(house = house,
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

                Spacer(Modifier.height(8.dp))

                Text(text = house.locationName, style = MaterialTheme.typography.labelLarge)

                //TODO("Add Line separator")

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
                        Text(text = "2KM From Your Location")
                    }
                    Text(text = "KES ${house.amount}", color = Color(0xFFF82500))
                }
            }
        }
    }
}

@Preview(name = "HouseImagePreview", showBackground = true, showSystemUi = true)
@Composable
fun pPopularHouseCard() {

    val house = House(
        images = listOf(painterResource(id = R.drawable.big_buck_bunny)),
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
            mobileNumber = "+123456789"
        ),
        reviews = emptyList(),  // Assuming no reviews initially.
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

    HewahBnBTheme {
        PopularHouseCard(
            house = house,
            isFavorite = true,
            onAddToFavouritesClicked = {}
        )
    }
}