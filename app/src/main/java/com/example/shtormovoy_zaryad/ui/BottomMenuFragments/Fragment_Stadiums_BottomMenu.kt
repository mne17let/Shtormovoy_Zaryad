package com.example.shtormovoy_zaryad.ui.BottomMenuFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val recycler: RecyclerView = view.findViewById(R.id.id_recyclerViewAllStadiums)
        val mylayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, true)
        recycler.layoutManager = mylayoutManager

        val adapter = StadiumsFragmentRecyclerViewAdapter()
        adapter.setList(stadiumViewModel.getStadiumsForAdapter())
        recycler.adapter = adapter

    }
}