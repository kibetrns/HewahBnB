package me.adipiscing_elit.hewahbnb.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import me.adipiscing_elit.hewahbnb.ui.components.ReviewsScreenContent
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewsScreen(
    hbViewModel: HBViewModel,
    navController: NavHostController,
    navigateToPreviousScreen: () -> Unit
) {

    var reviewDescription by remember { hbViewModel.reviewDescription }

    var ratingScore by remember { hbViewModel.ratingScore }

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
            profilePhoto = painterResource(id = R.drawable.dp_1)
        ),
        reviews = listOf(
            HouseReview(
                reviewId = "CsmVXCXDqf1_1",
                reviewDescription = "Review 1 Curabitur sagittis, risus at vestibulum" +
                        " libero nisl elementum ligula, ut efficitur elit felis vitae" +
                        " nisi. Ut non dignissim nisl. Vivamus cursus est sagittis elementum " +
                        "consequat. Nam pellentesque ",
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
                reviewDescription = "Review 2 Ut sit amet purus quam. Mauris venenatis arcu " +
                        "tortor, et fermentum lectus convallis vitae. Nunc ac malesuada" +
                        " tellus, ac varius sem. Cras efficitur quam ",
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
    )

    Scaffold(
        topBar = {
                 TopAppBar(
                     navigationIcon = {
                         IconButton(onClick = navigateToPreviousScreen) {
                             Icon(
                                 imageVector = Icons.Default.ArrowBack,
                                 contentDescription = stringResource(id = R.string.arrowBack)
                             )
                         } },
                     title = { Text(text = "") },
                 )
        },
        content = { innerPadding: PaddingValues ->
            ReviewsScreenContent(
                contentPadding = innerPadding,
                house = house,
                ratingScore = ratingScore,
                reviewDescription = reviewDescription,
                onRatingScoreSelected = {
                    ratingScore = it
                },
                onReviewDescriptionValueChange = {
                    reviewDescription = it
                },
                onPostReviewBtnClicked = {} //TODO("Handle this once the appropriate functions are created)

            )
        },
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    )

}