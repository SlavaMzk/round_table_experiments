package com.slvmk.restaurants_demo.ui.business_location

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.slvmk.R
import com.slvmk.restaurants_demo.ui.business_location.fragments.LocationListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantsDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurants_layout)
        val fragment = LocationListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment, "lb_list")
        transaction.commit()
    }
}