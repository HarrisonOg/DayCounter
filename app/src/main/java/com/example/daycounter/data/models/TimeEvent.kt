package com.example.daycounter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_table")
data class TimeEvent(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "time_as_string")
    val timeAsString: String,
    val daysUntil: Int,
    val title: String
)