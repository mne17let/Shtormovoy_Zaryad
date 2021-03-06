package com.example.shtormovoy_zaryad.ParentFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shtormovoy_zaryad.R
import com.example.shtormovoy_zaryad.BottomNavigation.Stadiums.StadiumsListPresenter

class FragmentStadium(): Fragment() {

    private lateinit var stadiumId: String
    private var stadiumsPresenter = StadiumsListPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.stadiumslist_one_stadium_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        stadiumId = arguments?.getString("StadiumId").toString()
        //Log.d("VLADIMIR", "$stadiumId в FragmentStadium принято")
        setStadiumData(view)
    }

    fun setStadiumData(stadiumView: View) {

        //Log.d("VLADIMIR", "$stadiumId в FragmentStadium при отображении данных стадиона")

        val textMark: TextView = stadiumView.findViewById(R.id.stadiums_list_one_stadium_mark_text_id)
        val textCount: TextView = stadiumView.findViewById(R.id.stadiums_list_one_stadium_number_of_people_text_id)
        val textName: TextView = stadiumView.findViewById(R.id.stadiums_list_one_stadium_name_id)
        val mark: TextView = stadiumView.findViewById(R.id.stadiums_list_one_stadium_mark_id)
        val countPeople: TextView = stadiumView.findViewById(R.id.stadiums_list_one_stadium_number_of_people_id)
        val photoStadium: ImageView = stadiumView.findViewById(R.id.stadiums_list_one_stadium_photo_id)

        val dataStadium = stadiumsPresenter.getStadiumData(stadiumId)

        textMark.setText(R.string.textForMarkTextView)
        textCount.setText(R.string.textForCountPeopleTextView)
        mark.text = dataStadium.mark.toString()
        countPeople.text = dataStadium.countPeople.toString()
        textName.text = dataStadium.stadiumName
        photoStadium.setImageResource(R.drawable.photo_pole_2)
    }
}