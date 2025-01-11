package com.example.hiltapp.domain.model

data class AddressModel(
    val postalCode: String,
    val street: String,
    val neighborhood: String,
    val city: String,
    val state: String
)