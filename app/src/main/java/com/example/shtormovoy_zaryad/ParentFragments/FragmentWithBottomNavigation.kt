package com.example.shtormovoy_zaryad.ParentFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shtormovoy_zaryad.R
import com.example.shtormovoy_zaryad.BottomNavigation.Chat.BottomMenuFragmentClass_Chats
import com.example.shtormovoy_zaryad.BottomNavigation.Profile.BottomMenuFragmentClass_Profile
import com.example.shtormovoy_zaryad.BottomNavigation.Stadiums.BottomMenuFragmentClass_Stadiums
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentWithBottomNavigation : Fragment() {

    // Числовой код для проверки текущего открытого фрагмента
    private var currentFragmentCode = 0

    // 3 фрагмента для экрана с BottomNavigation View
    private var fragmentStadiums = BottomMenuFragmentClass_Stadiums()
    private var fragmentChats = BottomMenuFragmentClass_Chats()
    private var fragmentProfile = BottomMenuFragmentClass_Profile()

    // Переменные для хранения ссылок на View-объекты
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // "Надуваю" XML-макет
        val view = inflater.inflate(R.layout.parent_layout_with_bottom_navigation, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        showStartBottomNavigationFragment()
        setBottomNavigationItemListener()
    }

    fun init(view: View) {
        // Инициализирую переменную для доступа к элементам на экране
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView_id)
    }

    fun showStartBottomNavigationFragment() {

        // Ставлю стартовый фрагмент на экран с BottomNavigationView
        childFragmentManager.beginTransaction().replace(R.id.frameForBottomNavigationFragments_id, fragmentStadiums).commit()
    }

    fun showBottomNavigationFragment(fragment: Fragment) {

        // Смена фрагментов по нажатию на кнопки BottomNavigationView
        childFragmentManager.beginTransaction().replace(R.id.frameForBottomNavigationFragments_id, fragment).commit()
    }

    fun checkingCurrentFragment(checkCode: Int) {

        // Проверка, открыт ли уже фрагмент, за который отвечает нажатая кнопка на BottomNavigationView
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

        // Устанавливаю Listener нажатий на BottomNavigationView
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