package com.example.daycounter.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daycounter.data.models.TimeEvent
import com.google.gson.Gson

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val events : MutableLiveData<List<TimeEvent>> by lazy {
        MutableLiveData<List<TimeEvent>>()
    }

    public fun getDataString() : String {
        return Gson().toJson(events)
    }

    public fun setData(list: List<TimeEvent>?) {
        /*events.clear()
        if(list != null) {
            events.addAll(list)
        }*/
        events.value = list
    }
}
