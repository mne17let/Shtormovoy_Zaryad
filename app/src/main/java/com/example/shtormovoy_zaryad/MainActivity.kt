package com.example.shtormovoy_zaryad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.*
import com.example.shtormovoy_zaryad.FragmentsMenu.*
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : AppCompatActivity() {

    val fr_pole = Fragment_Pole()
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
    }
}