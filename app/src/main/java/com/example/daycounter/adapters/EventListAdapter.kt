package com.example.daycounter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daycounter.R
import com.example.daycounter.data.models.TimeEvent

class EventListAdapter(
    val data: ArrayList<TimeEvent>,
    val onClick: () -> Unit
) : RecyclerView.Adapter<EventListViewHolder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EventListViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        val timeEvent : TimeEvent = data[position]
        holder.bind(timeEvent, onClick)
    }

}

class EventListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.event_list_item, parent, false)) {

    private var eventTitle: TextView? = null
    private var eventDaysCounter: TextView? = null
    private var eventDate: TextView? = null

    init {
        eventTitle = itemView.findViewById(R.id.event_item_title)
        eventDate = itemView.findViewById(R.id.event_item_date)
        eventDaysCounter = itemView.findViewById(R.id.event_item_days_counter)
    }

    fun bind(timeEvent: TimeEvent, onClick: () -> Unit) {
        eventTitle?.text = timeEvent.title
        eventDaysCounter?.text = "${timeEvent.daysUntil} days"
        eventDate?.text = timeEvent.timeAsString
        itemView.setOnClickListener { onClick }
    }

}