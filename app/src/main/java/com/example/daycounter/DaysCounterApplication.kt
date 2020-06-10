package com.example.daycounter

import android.app.Application
import androidx.room.Room
import com.example.daycounter.data.DatabaseService

class DaysCounterApplication: Application() {

    companion object {
        var database: DatabaseService? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, DatabaseService::class.java,
            "days-counter-list-db").build()
    }
}