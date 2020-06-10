package com.example.daycounter.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.daycounter.data.dao.TimeEventDAO
import com.example.daycounter.data.models.TimeEvent

class TimeEventRepository(private val dao: TimeEventDAO) {

    val allEvents: LiveData<List<TimeEvent>> = dao.getAll()

    suspend fun insert(timeEvent: TimeEvent) {
        dao.insertEvent(timeEvent)
    }

    suspend fun delete(timeEvent: TimeEvent) {
        dao.deleteEvent(timeEvent)
    }
}