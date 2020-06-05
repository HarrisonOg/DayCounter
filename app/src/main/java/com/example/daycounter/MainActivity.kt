package com.example.daycounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daycounter.ui.main.EventListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, EventListFragment.newInstance())
                    .commitNow()
        }
    }
}
