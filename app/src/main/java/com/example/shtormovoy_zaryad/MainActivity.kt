package com.example.shtormovoy_zaryad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shtormovoy_zaryad.ui.ParentFragments.FragmentWithBottomNavigation



class MainActivity : AppCompatActivity() {

    var fragmentBottomNavigation = FragmentWithBottomNavigation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)
        setStartFragment()
    }


    fun setStartFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.parentFrame, fragmentBottomNavigation).commit()
    }
}