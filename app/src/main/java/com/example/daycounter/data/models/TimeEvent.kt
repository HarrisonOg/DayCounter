package com.example.daycounter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "event_table")
data class TimeEvent(
    @ColumnInfo(name = "time_as_string")
    val timeAsString: String,
    @ColumnInfo(name = "days")
    val daysUntil: Int,
    val title: String,
    val date: OffsetDateTime? = null
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0
}