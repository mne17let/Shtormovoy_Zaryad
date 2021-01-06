package com.example.shtormovoy_zaryad

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.shtormovoy_zaryad.Model.ObjectModels.StadiumModel
import com.example.shtormovoy_zaryad.ui.BottomMenuFragments.Fragment_Chats_BottomMenu
import com.example.shtormovoy_zaryad.ui.BottomMenuFragments.Fragment_Profile_BottomMenu
import com.example.shtormovoy_zaryad.ui.BottomMenuFragments.Fragment_Stadiums_BottomMenu
import com.example.shtormovoy_zaryad.ui.StadiumsFragmentRecyclerViewAdapter.StadiumsFragmentRecyclerViewAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.layout_main_activity.*


class MainActivity : AppCompatActivity() {

    var currentFragmentCode = 0

    val fragmentStadiums = Fragment_Stadiums_BottomMenu()
    val fragmentChats = Fragment_Chats_BottomMenu()
    val fragmentProfile = Fragment_Profile_BottomMenu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)
        setStartFragment()
        setListenerOnBottomNavigation()
    }


    fun setStartFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frameForFragments, fragmentStadiums).commit()
    }



    fun setListenerOnBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.bottomMenuItemXML_Stadium -> checkingCurrentFragment(0)
                    R.id.bottomMenuItemXML_Chat -> checkingCurrentFragment(1)
                    R.id.bottomMenuItemXML_Profile -> checkingCurrentFragment(2)
                }
                return true
            }
        })
    }

    fun checkingCurrentFragment(checkCode: Int) {
        if (checkCode == currentFragmentCode) {
            Toast.makeText(this,"Same Fragment", Toast.LENGTH_SHORT).show()
            return
        } else {
            when (checkCode) {
                0 -> setBottomNavigationFragment(fragmentStadiums)
                1 -> setBottomNavigationFragment(fragmentChats)
                2 -> setBottomNavigationFragment(fragmentProfile)
            }
            currentFragmentCode = checkCode
        }
    }


    fun setBottomNavigationFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameForFragments, fragment).commit()
    }
}