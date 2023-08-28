package com.bestway.carpool.models

data class AvailableCarPool(
    val imageUrl: String? = null,
    val firstName: String,
    val lastName: String,
    val carRegistrationNumber: String,
    val startDestination: String,
    val endDestination: String
)
