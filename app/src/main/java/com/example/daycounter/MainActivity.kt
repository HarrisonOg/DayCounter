package com.example.daycounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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

    fun replace(newFragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, newFragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}
