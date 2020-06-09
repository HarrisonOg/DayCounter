package com.example.daycounter.ui.main

import androidx.lifecycle.ViewModel
import com.example.daycounter.data.models.TimeEvent
import com.google.gson.Gson

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val alerts = mutableListOf<TimeEvent>()

    public fun getDataString() : String {
        return Gson().toJson(alerts)
    }

    public fun setData(list: List<TimeEvent>?) {
        alerts.clear()
        if(list != null) {
            alerts.addAll(list)
        }
    }
}
