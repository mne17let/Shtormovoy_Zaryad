package com.example.shtormovoy_zaryad.ui.BottomMenuFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shtormovoy_zaryad.Model.ObjectModels.StadiumModel
import com.example.shtormovoy_zaryad.R
import com.example.shtormovoy_zaryad.ui.StadiumsFragmentRecyclerViewAdapter.StadiumsFragmentRecyclerViewAdapter

class Fragment_Stadiums_BottomMenu: Fragment(){

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
        val recycler: RecyclerView = view.findViewById(R.id.id_recyclerViewAllStadiums)
        val mylayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, true)
        recycler.layoutManager = mylayoutManager
        val list = ArrayList<StadiumModel>()

        val stadium1 = StadiumModel("Поле 1", 100, 6)
        val stadium2 = StadiumModel("Поле 2", 0, 19)
        val stadium3 = StadiumModel("Поле 3", 10, 14)
        val stadium4 = StadiumModel("Поле 4", 15, 0)
        val stadium5 = StadiumModel("Поле 5", 150, 9)
        val stadium6 = StadiumModel("Поле 6", 6, 3)

        list.add(stadium1)
        list.add(stadium2)
        list.add(stadium3)
        list.add(stadium4)
        list.add(stadium5)
        list.add(stadium6)

        val adapter = StadiumsFragmentRecyclerViewAdapter()
        adapter.setList(list)
        recycler.adapter = adapter

    }
}