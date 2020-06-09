package com.example.daycounter.data.dao

import androidx.room.*
import com.example.daycounter.data.models.TimeEvent

@Dao
interface TimeEventDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event: TimeEvent)

    @Update
    fun updateEvent(event: TimeEvent)

    @Delete
    fun deleteEvent(event: TimeEvent)


}