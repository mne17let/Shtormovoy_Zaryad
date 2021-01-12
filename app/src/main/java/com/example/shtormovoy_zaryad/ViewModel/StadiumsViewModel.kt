package com.example.shtormovoy_zaryad.ViewModel

import com.example.shtormovoy_zaryad.Model.ObjectModels.StadiumModel
import com.example.shtormovoy_zaryad.Model.StadiumRepository.StadiumRepository


class StadiumsViewModel {
    val stadiumRepository = StadiumRepository()

    fun getStadiumsForAdapter(): ArrayList<StadiumModel> {
        return stadiumRepository.getStadiums()
    }
}