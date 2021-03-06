package com.example.shtormovoy_zaryad.BottomNavigation.Stadiums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shtormovoy_zaryad.R

class BottomMenuFragmentClass_Stadiums: Fragment(){

    // Переменная презентера
    val stadiumsListPresenter = StadiumsListPresenter()

    // Переменная, куда упакую RecyclerView
    lateinit var recycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.stadiums_stadiumslist_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter(view)
    }

    fun setAdapter(view: View) {

        // Инициализирую переменную RecyclerView. Затем создаю LayoutManager для RecyclerView
        recycler = view.findViewById(R.id.stadiums_StadiumsList_RecyclerView_id)
        val mylayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)


        // Создаю фрагмент адаптера для RecyclerView со списком полей.
        // Устанавливаю список полей в адаптер. Перед этим получаю его из Presenter'а
        val adapter = StadiumsListRecyclerViewAdapter()
        adapter.setList(stadiumsListPresenter.getStadiumsForAdapter())

        // Установка адаптера и LayoutManager'а для RecyclerView
        recycler.layoutManager = mylayoutManager
        recycler.adapter = adapter

    }
}