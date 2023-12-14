package me.adipiscing_elit.hewahbnb.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.plus
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
import me.adipiscing_elit.hewahbnb.ui.components.HomeTopAppBar
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    hbViewModel: HBViewModel
) {

    val houses = listOf(
        House(
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
                checkOut = Clock.System.now().plus(1, DateTimeUnit.HOUR),
                totalAmount = 1200,
                customerId = "customer123",
                houseOwnerId = "owner123"
            )
        ),

        House(
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
                checkOut = Clock.System.now().plus(1, DateTimeUnit.HOUR),
                totalAmount = 1200,
                customerId = "customer123",
                houseOwnerId = "owner123"
            )
        ),

        House(
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
                checkOut = Clock.System.now().plus(1, DateTimeUnit.HOUR),
                totalAmount = 1200,
                customerId = "customer123",
                houseOwnerId = "owner123"
            )
        )

    )

    val searchAppBarState by hbViewModel.searchAppBarState
    val searchTextState by hbViewModel.searchTextState

    Scaffold(
        topBar = {
            TopAppBar(title = { /*TODO*/ })
            HomeTopAppBar(
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState,
                hbViewModel = hbViewModel
            )
        },
        content = { innerPadding: PaddingValues ->
            HomeScreenContent(
                houses = houses,
                innerPadding = innerPadding
            )
        }
    )
}


@Preview(name = "HomeScreenPreview", showBackground = true, showSystemUi = true)
@Composable
fun  pHomeScreen() {
    val hbViewModel = hiltViewModel<HBViewModel>()

    HomeScreen(
        hbViewModel = hbViewModel
    )


}
