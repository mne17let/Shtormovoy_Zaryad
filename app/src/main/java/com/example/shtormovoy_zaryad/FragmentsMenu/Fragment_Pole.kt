package com.example.shtormovoy_zaryad.FragmentsMenu

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.shtormovoy_zaryad.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.spisok_pole_fragment.*

class Fragment_Pole : Fragment() {

    /*private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2

    private lateinit var tab1: TabLayout.Tab
    private lateinit var tab2: TabLayout.Tab

    var fr_pole_vse = Fragment_Pole_Vse()
    var fr_pole_fav = Fragment_Pole_Fav()




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.spisok_pole_fragment, container, false)
        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager2 = view.findViewById(R.id.view_pager_2_layout)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTabLayout()
        setViewPager2()
        viewPager2.isSaveEnabled = false


    }

    override fun onStart() {
        super.onStart()
        view_pager_2_layout.setCurrentItem(cur_fr, false)
    }


    fun setTabLayout () : Unit {
        tab1 = tabLayout.newTab().setText(R.string.pager_pole_vse)
        tab2 = tabLayout.newTab().setText(R.string.pager_pole_fav)

        tabLayout.addTab(tab1)
        tabLayout.addTab(tab2)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) : Unit {
                viewPager2.setCurrentItem(tab.position)
                cur_fr = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab): Unit {}
            override fun onTabReselected(tab: TabLayout.Tab): Unit {}
        })
    }



    fun setViewPager2() : Unit {

        viewPager2.adapter = PagerAdapter(childFragmentManager, lifecycle)

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> tab1.select()
                    1 -> tab2.select()
                }
                cur_fr = position
            }
        })
    }




    inner class PagerAdapter(fm : FragmentManager?, lifecycle: Lifecycle) : FragmentStateAdapter(fm!!, lifecycle) {


        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> return fr_pole_vse
                1 -> return fr_pole_fav
                else -> return fr_pole_vse
            }
        }
    }

    companion object {
        var cur_fr = 0
    }*/
}