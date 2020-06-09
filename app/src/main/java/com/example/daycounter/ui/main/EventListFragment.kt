package com.example.daycounter.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.daycounter.MainActivity
import com.example.daycounter.R
import com.example.daycounter.adapters.EventListAdapter
import com.example.daycounter.models.TimeEvent
import com.example.daycounter.ui.create.CreateEventFragment
import com.example.daycounter.utils.CREATE_NEW_EVENT_REQUEST_CODE
import com.example.daycounter.utils.DATA_KEY
import com.example.daycounter.utils.SHARED_PREFERENCES_KEY
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EventListFragment : Fragment() {

    lateinit var addDateButton: FloatingActionButton
    lateinit var eventRecyclerView: RecyclerView

    lateinit var adapter: EventListAdapter

    companion object {
        fun newInstance() = EventListFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View  =  inflater.inflate(R.layout.event_list_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addDateButton = view.findViewById(R.id.new_event_button)
        eventRecyclerView = view.findViewById(R.id.event_recyclerview)

        var dataList : List<TimeEvent>? = getDataFromSharedPreferences()
        if(dataList == null) {
            //create new data list
            dataList = listOf()
        }
        viewModel.setData(dataList)

        addDateButton.setOnClickListener { startCreateEventFragment() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }


    private fun getDataFromSharedPreferences() : List<TimeEvent>? {
        val sharedPref = context?.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
        val jsonString = sharedPref?.getString(DATA_KEY, "")
        val timeEventType = object : TypeToken<List<TimeEvent>>() {}.type
        return Gson().fromJson(jsonString, timeEventType)
    }

    private fun saveDataToSavedPreferences(data: List<TimeEvent>) {
        val sharedPref = context?.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
        val jsonString = Gson().toJson(data)
        sharedPref?.edit()?.putString(DATA_KEY, jsonString)?.apply()
    }

    private fun startCreateEventFragment() {
        /*parentFragmentManager.beginTransaction()
            .replace(R.id.container, CreateEventFragment.newInstance())
            .commitNow()*/

        //
        val createEventFragment = CreateEventFragment.newInstance()
        val tag = CreateEventFragment::class.java.simpleName

        createEventFragment.setTargetFragment(this, CREATE_NEW_EVENT_REQUEST_CODE)
        (activity as? MainActivity)?.replace(createEventFragment, tag)
    }

    fun addEvent(event: TimeEvent) {
        //viewmodel add event to list here
    }
}
