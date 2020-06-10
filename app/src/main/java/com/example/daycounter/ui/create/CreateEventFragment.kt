package com.example.daycounter.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daycounter.R
import com.example.daycounter.data.models.TimeEvent
import com.example.daycounter.ui.main.EventListFragment

/**
 * separate fragment
 * called by EventListFragment
 * expected to respond back with "addEvent" or "noEvent"
 */

class CreateEventFragment : Fragment() {

    lateinit var event: TimeEvent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.create_event_dialog_fragment, container, false)

    companion object {
        fun newInstance() = EventListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    fun returnWithEvent() {
        //
        (targetFragment as? EventListFragment)?.addEvent(event)
        activity?.supportFragmentManager?.popBackStackImmediate()
    }
}