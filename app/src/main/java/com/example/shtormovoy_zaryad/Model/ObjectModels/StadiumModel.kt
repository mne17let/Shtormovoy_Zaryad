package com.example.shtormovoy_zaryad.Model.ObjectModels

// Класс-модель для стадиона

data class StadiumModel(var stadiumName: String,
                        var mark: Int,
                        var countPeople: Int,
                        var imageURL: String = "",
                        var stadiumId: String = ""

)