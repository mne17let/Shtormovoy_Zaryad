package com.example.shtormovoy_zaryad.ui.ParentFragments

import android.net.sip.SipSession
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shtormovoy_zaryad.R
import com.example.shtormovoy_zaryad.ui.BottomMenuFragments.Fragment_Chats_BottomMenu
import com.example.shtormovoy_zaryad.ui.BottomMenuFragments.Fragment_Profile_BottomMenu
import com.example.shtormovoy_zaryad.ui.BottomMenuFragments.Fragment_Stadiums_BottomMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.layout_bottom_navigation_menu.*

class FragmentWithBottomNavigation : Fragment() {

    private var currentFragmentCode = 0

    private var fragmentStadiums = Fragment_Stadiums_BottomMenu()
    private var fragmentChats = Fragment_Chats_BottomMenu()
    private var fragmentProfile = Fragment_Profile_BottomMenu()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_bottom_navigation_menu, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showStartBottomNavigationFragment()
        setBottomNavigationItemListener()
    }


    fun showStartBottomNavigationFragment() {
        childFragmentManager.beginTransaction().replace(R.id.frameForBottomNavigationFragments, fragmentStadiums).commit()
    }

    fun showBottomNavigationFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().replace(R.id.frameForBottomNavigationFragments, fragment).commit()
    }

    fun checkingCurrentFragment(checkCode: Int) {
        if (checkCode == currentFragmentCode) {
            Toast.makeText(context, "Same Fragment", Toast.LENGTH_SHORT).show()
            return
        } else {
            when (checkCode) {
                0 -> showBottomNavigationFragment(fragmentStadiums)
                1 -> showBottomNavigationFragment(fragmentChats)
                2 -> showBottomNavigationFragment(fragmentProfile)
            }
            currentFragmentCode = checkCode
        }
    }


    fun setBottomNavigationItemListener() {
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

}