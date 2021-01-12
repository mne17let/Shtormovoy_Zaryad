package com.example.shtormovoy_zaryad.Model.StadiumRepository

import com.example.shtormovoy_zaryad.Model.ObjectModels.StadiumModel

class StadiumRepository {
    private val list: ArrayList<StadiumModel> = ArrayList()

    val stadium1 = StadiumModel("Поле 1", 100, 6)
    val stadium2 = StadiumModel("Поле 2", 0, 19)
    val stadium3 = StadiumModel("Поле 3", 10, 14)
    val stadium4 = StadiumModel("Поле 4", 15, 0)
    val stadium5 = StadiumModel("Поле 5", 150, 9)
    val stadium6 = StadiumModel("Поле 6", 6, 3)

    fun collect() {
        list.clear()
        list.add(stadium1)
        list.add(stadium2)
        list.add(stadium3)
        list.add(stadium4)
        list.add(stadium5)
        list.add(stadium6)
    }

    fun getStadiums(): ArrayList<StadiumModel> {
        collect()
        return list
    }
}