package me.adipiscing_elit.hewahbnb.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.plus
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.data.model.Amenity
import me.adipiscing_elit.hewahbnb.data.model.Availability
import me.adipiscing_elit.hewahbnb.data.model.Customer
import me.adipiscing_elit.hewahbnb.data.model.FurnishType
import me.adipiscing_elit.hewahbnb.data.model.House
import me.adipiscing_elit.hewahbnb.data.model.HouseBooking
import me.adipiscing_elit.hewahbnb.data.model.HouseOwner
import me.adipiscing_elit.hewahbnb.data.model.HouseReview
import me.adipiscing_elit.hewahbnb.data.model.HouseType
import me.adipiscing_elit.hewahbnb.data.model.Location
import me.adipiscing_elit.hewahbnb.data.model.PayFrequency
import me.adipiscing_elit.hewahbnb.data.model.RatingScore
import me.adipiscing_elit.hewahbnb.ui.components.BottomNavBar
import me.adipiscing_elit.hewahbnb.ui.components.HouseDetailsContent


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HouseDetailsScreen(
    navController: NavHostController,
    houseId: String,
    navigateToReviewsScreen: (houseId: String) -> Unit
) {

    val houses = listOf(
        House(
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
                profilePhoto = painterResource(id = R.drawable.dp_1)
            ),
            reviews = listOf(
                HouseReview(
                    reviewId = "CsmVXCXDqf1_1",
                    reviewDescription = "Review 1",
                    reviewer = Customer(
                        fullName = "User1",
                        mpesaNumber = 254711223344,
                        email = "user.1@example.com",
                        password = "User1.Password",
                        username = "User.1",
                        profilePhoto = painterResource(id = R.drawable.dp_3)
                    ),
                    ratingScore = RatingScore.FIVE,
                    dateTimeReviewed = Clock.System.now()
                ),
                HouseReview(
                    reviewId = "CsmVXCXDqf1_2",
                    reviewDescription = "Review 2",
                    reviewer = Customer(
                        fullName = "User2",
                        mpesaNumber = 254711223345,
                        email = "user.2@example.com",
                        password = "User2.Password",
                        username = "User.2",
                        profilePhoto = painterResource(id = R.drawable.dp_4)
                    ),
                    ratingScore = RatingScore.THREE,
                    dateTimeReviewed = Clock.System.now()
                )
            ),
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
            houseId = "CsmVXCXDqf2",
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
                profilePhoto = painterResource(id = R.drawable.dp_5)
            ),
            reviews = listOf(
                HouseReview(
                    reviewId = "CsmVXCXDqf2_1",
                    reviewDescription = "Review 1",
                    reviewer = Customer(
                        fullName = "User1",
                        mpesaNumber = 254711223344,
                        email = "user.1@example.com",
                        password = "User1.Password",
                        username = "User.1",
                        profilePhoto = painterResource(id = R.drawable.dp_3)
                    ),
                    ratingScore = RatingScore.FIVE,
                    dateTimeReviewed = Clock.System.now()
                ),
                HouseReview(
                    reviewId = "CsmVXCXDqf2_2",
                    reviewDescription = "Review 2",
                    reviewer = Customer(
                        fullName = "User2",
                        mpesaNumber = 254711223345,
                        email = "user.2@example.com",
                        password = "User2.Password",
                        username = "User.2",
                        profilePhoto = painterResource(id = R.drawable.dp_4)
                    ),
                    ratingScore = RatingScore.THREE,
                    dateTimeReviewed = Clock.System.now()
                )
            ),
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
            houseId = "CsmVXCXDqf3",
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
                profilePhoto = painterResource(id = R.drawable.elephants_dream)
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
                checkOut = Clock.System.now().plus(1, DateTimeUnit.HOUR),
                totalAmount = 1200,
                customerId = "customer123",
                houseOwnerId = "owner123"
            )
        )

    )

    Scaffold(
        topBar = {

        },
        content = { contentPadding: PaddingValues ->
            HouseDetailsContent(
                house = houses[1],
                contentPadding = contentPadding,
                onAddToPhoneIconClicked = {},
                navigateToReviewsScreen = navigateToReviewsScreen
            )
        },
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    )
}