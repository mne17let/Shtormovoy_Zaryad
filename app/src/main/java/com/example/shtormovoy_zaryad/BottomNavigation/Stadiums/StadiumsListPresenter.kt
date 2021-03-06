package com.example.shtormovoy_zaryad.BottomNavigation.Stadiums

import android.util.Log
import com.example.shtormovoy_zaryad.DataBase.ObjectModels.StadiumModel
import com.example.shtormovoy_zaryad.DataBase.StadiumRepository.StadiumRepository


class StadiumsListPresenter {

    // ViewModel для отображения списка полей и одного поля

    val stadiumRepository = StadiumRepository()

    fun getStadiumsForAdapter(): ArrayList<StadiumModel> {
        return stadiumRepository.getStadiums()
    }

    fun getStadiumData(id: String): StadiumModel {
        Log.d("VLADIMIR", "$id в ViewModel при передаче в базу данных")
        val a = stadiumRepository.getStadiumById(id)
        return a
    }
}