package com.example.shtormovoy_zaryad.DataBase.StadiumRepository

import android.util.Log
import com.example.shtormovoy_zaryad.DataBase.ObjectModels.StadiumModel

class StadiumRepository {
    private val list: ArrayList<StadiumModel> = ArrayList()
    private lateinit var stadiumToReturn: StadiumModel

    val stadium1 = StadiumModel("Поле 1", 100, 6, stadiumId = "id_1")
    val stadium2 = StadiumModel("Поле 2", 0, 19, stadiumId = "id_2")
    val stadium3 = StadiumModel("Поле 3", 10, 14, stadiumId = "id_3")
    val stadium4 = StadiumModel("Поле 4", 15, 0, stadiumId = "id_4")
    val stadium5 = StadiumModel("Поле 5", 150, 9, stadiumId = "id_5")
    val stadium6 = StadiumModel("Поле 6", 6, 3, stadiumId = "id_6")

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

        // Метод отдаёт список полей во ViewModel
        collect()
        return list
    }

    fun getStadiumById(id: String): StadiumModel {
        collect()

        Log.d("VLADIMIR", "$id Repository при поиске стадиона")

        // Метод нахоидт нужный стадион по id в списке и отдаёт его во ViewModel
        for (i in list) {
            if (i.stadiumId == id) {
                stadiumToReturn = i
                Log.d("VLADIMIR", "${stadiumToReturn.stadiumId} в репозитории найден")
            }
        }
        return stadiumToReturn
    }
}