package me.adipiscing_elit.hewahbnb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.data.model.Amenity
import me.adipiscing_elit.hewahbnb.data.model.Availability
import me.adipiscing_elit.hewahbnb.data.model.FurnishType
import me.adipiscing_elit.hewahbnb.data.model.House
import me.adipiscing_elit.hewahbnb.data.model.HouseBooking
import me.adipiscing_elit.hewahbnb.data.model.HouseOwner
import me.adipiscing_elit.hewahbnb.data.model.HouseType
import me.adipiscing_elit.hewahbnb.data.model.Location
import me.adipiscing_elit.hewahbnb.data.model.PayFrequency
import me.adipiscing_elit.hewahbnb.ui.theme.HewahBnBTheme
import kotlin.time.Duration

@Composable
fun HouseImageContainer(
    house: House,
    isFavorite: Boolean,
    modifier: Modifier,
    onAddToFavouritesClicked: () -> Unit
) {
    Box(modifier = modifier) {
        //TODO("Change this to use AsyncImage")
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart),
            painter = house.images[0],
            contentDescription = stringResource(id = R.string.house_image)
        )

        Surface(
            color = Color(0xFFAFAFAF),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopEnd),
        ) {
            IconButton(
                modifier = Modifier
                    .size(32.dp),
                onClick = { onAddToFavouritesClicked() }
            ) {

                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                    contentDescription = stringResource(id = R.string.favorite_button),
                    tint = Color(0xFFD20000),
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview(name = "HouseImagePreview", showBackground = true, showSystemUi = true)
@Composable
fun pHouseImage() {

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

    HewahBnBTheme {
        HouseImageContainer(house = house, isFavorite = true, modifier = Modifier) {

        }
    }
}