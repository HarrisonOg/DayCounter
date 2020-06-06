package com.example.daycounter.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.daycounter.models.TimeEvent
import com.google.gson.Gson
import java.sql.Time

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
