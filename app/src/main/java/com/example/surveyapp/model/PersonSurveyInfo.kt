package com.example.surveyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonSurveyInfo(
    val person: Person?,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String
) : Parcelable
