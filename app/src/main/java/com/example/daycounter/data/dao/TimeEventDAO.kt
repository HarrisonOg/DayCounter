package com.example.daycounter.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.daycounter.data.models.TimeEvent

@Dao
interface TimeEventDAO {

    @Query("SELECT * FROM event_table ORDER BY datetime(date)")
    fun getAllOrdered() : LiveData<List<TimeEvent>>

    @Query("SELECT * FROM event_table")
    fun getAll() : LiveData<List<TimeEvent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: TimeEvent)

   /* @Update
    suspend fun updateEvent(event: TimeEvent)*/

    @Delete
    suspend fun deleteEvent(event: TimeEvent)
}