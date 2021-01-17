package com.example.shtormovoy_zaryad.ViewModel

import android.util.Log
import com.example.shtormovoy_zaryad.Model.ObjectModels.StadiumModel
import com.example.shtormovoy_zaryad.Model.StadiumRepository.StadiumRepository


class StadiumsViewModel {

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