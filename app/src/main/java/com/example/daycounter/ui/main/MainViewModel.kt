package com.example.daycounter.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.daycounter.data.DatabaseService
import com.example.daycounter.data.TimeEventRepository
import com.example.daycounter.data.models.TimeEvent
import com.google.gson.Gson
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository :TimeEventRepository
    var events : LiveData<List<TimeEvent>>

    init {
        val eventDAO = DatabaseService.getDatabase(application).Dao()
        repository = TimeEventRepository(eventDAO)
        events = repository.allEvents
    }

    public fun getDataString() : String {
        return Gson().toJson(events)
    }

    fun insert(timeEvent: TimeEvent) = viewModelScope.launch {
        repository.insert(timeEvent)
    }


}
