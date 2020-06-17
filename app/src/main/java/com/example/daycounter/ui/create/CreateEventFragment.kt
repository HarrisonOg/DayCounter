package com.example.daycounter.ui.create

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.daycounter.R
import com.example.daycounter.calculateTimeUntil
import com.example.daycounter.data.models.TimeEvent
import com.example.daycounter.ui.main.EventListFragment
import java.time.OffsetDateTime
import java.util.*

/**
 * separate fragment
 * called by EventListFragment
 * expected to respond back with "addEvent" or "noEvent"
 */

class CreateEventFragment : Fragment() {

    lateinit var titleText: EditText
    lateinit var dateText: TextView
    lateinit var dayDisplay: TextView
    lateinit var datePickerButton: Button
    lateinit var createEventButton: Button
    var cal = Calendar.getInstance()
    var choseDate = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.create_event_fragment, container, false)

    companion object {
        fun newInstance() = EventListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleText = view.findViewById(R.id.title_edit_create_event)
        dateText = view.findViewById(R.id.date_text_create_event)
        dayDisplay = view.findViewById(R.id.day_display_create_event)
        datePickerButton = view.findViewById(R.id.date_picker_create_event)
        createEventButton = view.findViewById(R.id.create_event_button)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _ , year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                choseDate = true
            }

        datePickerButton.setOnClickListener {
            DatePickerDialog(requireActivity(), dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    fun createEvent() {
        if(choseDate) {
            val date: Date = cal.time
            val offsetDateTime = OffsetDateTime.from(date.toInstant())
            //check if title is entered
            //calculate days until
            val daysUntil = calculateTimeUntil(offsetDateTime)

            if(titleText.text.isNotEmpty()) {
                val event = TimeEvent(title = titleText.text.toString(),
                    timeAsString = offsetDateTime.toString(),
                    daysUntil =  daysUntil)
                returnWithEvent(event)
            }

        } else {
            //show message "choose date"
        }
    }

    fun returnWithEvent(event: TimeEvent) {
        //
        (targetFragment as? EventListFragment)?.addEvent(event)
        activity?.supportFragmentManager?.popBackStackImmediate()
    }
}