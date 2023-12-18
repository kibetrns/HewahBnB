package me.adipiscing_elit.hewahbnb.data.model



/*
  TODO(Check if I would have to change this to User,
    or how I could merge it HouseOwner. To decide once I finalise on Authorization and Roles)
*/
data class Customers(
    val fullName: String,
    val mpesaNumber: Long,
    val email: String,
    val password: String,
    val username: String

)