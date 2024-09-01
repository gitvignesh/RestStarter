package com.karnamic.reststarter.data.remote.responses

data class AuthUserProfileResponse(
    val userId: String,
    val email: String,
    val name: String
)
