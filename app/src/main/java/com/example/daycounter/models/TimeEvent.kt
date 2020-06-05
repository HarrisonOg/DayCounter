package com.example.daycounter.models

data class TimeEvent(
    val timeAsString: String,
    val daysUntil: Int,
    val title: String,
    val description: String
)