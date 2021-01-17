package com.example.shtormovoy_zaryad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.shtormovoy_zaryad.ui.ParentFragments.FragmentStadium
import com.example.shtormovoy_zaryad.ui.ParentFragments.FragmentWithBottomNavigation



class MainActivity : AppCompatActivity() {

    // Создаю родительские фрагменты и храню их в переменных для того, чтобы они хранили своё состояние, пока не будут удалены
    var fragmentBottomNavigation = FragmentWithBottomNavigation()
    var fragmentStadium = FragmentStadium()

    init {
        // Инициализация статичной переменной для хранения ссылки на последний созданный объект данного класса
        mainActivity = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)
        setStartFragment()
    }

    fun setStartFragment() {
        // Ставлю на экран стартовый фрагмент - фрагмент с BottomNavigationView
        supportFragmentManager.beginTransaction().replace(R.id.parentFrame, fragmentBottomNavigation).commit()
    }

    fun showOneStadiumFragment(id: String) {
        // 1. Создаю Bundle, куда передаю id поля для отображения его данных во фрагменте поля
        // 2. Затем устанавливаю данный фрагмент в контейнер
        val bundleForStadium = Bundle()
        bundleForStadium.putString("StadiumId", id)
        fragmentStadium.arguments = bundleForStadium

        Log.d("VLADIMIR", "$id в MainActivity при создании фрагмента")

        supportFragmentManager.beginTransaction().replace(R.id.parentFrame, fragmentStadium)
            .addToBackStack(null).commit()
    }

    companion object {
        // Статичная переменная, которая будет хранить в себе ссылку на последний созданный объект данного класса
        lateinit var mainActivity: MainActivity
    }
}