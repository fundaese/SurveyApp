package com.example.surveyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val age: Int,
    val email: String,
    val country: String,
    val city: String,
) : Parcelable
