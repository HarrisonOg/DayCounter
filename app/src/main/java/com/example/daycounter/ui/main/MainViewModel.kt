package com.example.daycounter.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.daycounter.models.TimeEvent
import com.google.gson.Gson

class MainViewModel(
    data: List<TimeEvent>
) : ViewModel() {
    // TODO: Implement the ViewModel

    val alerts = mutableListOf<TimeEvent>()

    init {

    }

    public fun getDataString() : String {
        return Gson().toJson(alerts)
    }
}
