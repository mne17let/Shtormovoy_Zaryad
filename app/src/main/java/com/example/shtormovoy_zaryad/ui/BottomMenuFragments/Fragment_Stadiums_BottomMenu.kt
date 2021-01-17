package com.example.shtormovoy_zaryad.ui.BottomMenuFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shtormovoy_zaryad.MainActivity
import com.example.shtormovoy_zaryad.R
import com.example.shtormovoy_zaryad.ViewModel.StadiumsViewModel
import com.example.shtormovoy_zaryad.ui.RecyclerViewAdapters.StadiumsFragmentRecyclerViewAdapter

class Fragment_Stadiums_BottomMenu: Fragment(){

    val stadiumViewModel = StadiumsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_stadiums_fragment_bottom_menu, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter(view)
    }

    fun setAdapter(view: View) {

        // Создаю и инициализирую переменную RecyclerView. Затем создаю и назначаю LayoutManager для RecyclerView
        val recycler: RecyclerView = view.findViewById(R.id.id_recyclerViewAllStadiums)
        val mylayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = mylayoutManager

        // Создаю фрагмент адаптера для RecyclerView с полями
        val adapter = StadiumsFragmentRecyclerViewAdapter()

        // Устанавливаю список полей в адаптер. Перед этим получаю его из ViewModel
        adapter.setList(stadiumViewModel.getStadiumsForAdapter())

        // Установка адаптера на RecyclerView
        recycler.adapter = adapter

    }
}