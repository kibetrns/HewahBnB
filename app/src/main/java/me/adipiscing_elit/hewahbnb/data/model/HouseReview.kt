package me.adipiscing_elit.hewahbnb.data.model

import kotlinx.datetime.Instant

data class HouseReview(
    val reviewId: String,
    val reviewDescription: String,
    val reviewer: Customers,
    val ratingScore: RatingScore,
    val dateTimeReviewed: Instant,
)