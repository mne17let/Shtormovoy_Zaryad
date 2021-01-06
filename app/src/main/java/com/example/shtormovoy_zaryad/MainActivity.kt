package com.example.shtormovoy_zaryad

import android.content.ClipData
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.*
import com.example.shtormovoy_zaryad.FragmentsMenu.*
import com.example.shtormovoy_zaryad.ui.Fragment_Chats_BottomMenu
import com.example.shtormovoy_zaryad.ui.Fragment_Profile_BottomMenu
import com.example.shtormovoy_zaryad.ui.Fragment_Stadiums_BottomMenu
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.layout_main_activity.*


class MainActivity : AppCompatActivity() {

    val fragmentManager = supportFragmentManager

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
        fragmentManager.beginTransaction().replace(R.id.frameForFragments, fragmentStadiums).commit()
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
        fragmentManager.beginTransaction().replace(R.id.frameForFragments, fragment).commit()
    }






    /*val fr_pole = Fragment_Pole()
    val fr_chats = Fragment_Chats()
    val fr_profile = Fragment_Profile()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        makeCurrentFragment(cur_fr_chislo)

        bottom_nav_id.setOnNavigationItemSelectedListener {
            makeCurrentFragment(
                when (it.itemId) {
                    R.id.bottom_menu_pole -> pole_pos
                    R.id.bottom_menu_chats -> chats_pos
                    R.id.bottom_menu_profile -> profile_pos
                    else -> no_pos
                }
            )
            true
        }
    }

    fun showFragment(fr: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_to_replace, fr)
            setTransition(TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }

    private fun makeCurrentFragment(chislo: Int) {
        if (chislo == no_pos) {
            showFragment(fr_pole)
            return
        }

        if (chislo == cur_fr_chislo) return

        cur_fr_chislo = chislo

        when (cur_fr_chislo) {
            pole_pos -> showFragment(fr_pole)
            chats_pos -> showFragment(fr_chats)
            profile_pos -> showFragment(fr_profile)
        }

    }

    companion object {
        val no_pos = -1
        val pole_pos = 0
        val chats_pos = 1
        val profile_pos = 2

        var cur_fr_chislo = no_pos
    }*/
}