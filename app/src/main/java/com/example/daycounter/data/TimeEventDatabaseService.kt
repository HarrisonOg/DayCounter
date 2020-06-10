package com.example.daycounter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daycounter.data.dao.TimeEventDAO
import com.example.daycounter.data.models.TimeEvent

@Database(entities = arrayOf(TimeEvent::class), version = 1, exportSchema = false)
public abstract class DatabaseService : RoomDatabase() {
    abstract fun Dao() : TimeEventDAO

    companion object {

        @Volatile
        private var INSTANCE : DatabaseService? = null

        fun getDatabase(context: Context) : DatabaseService {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseService::class.java,
                    "days_counter_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}