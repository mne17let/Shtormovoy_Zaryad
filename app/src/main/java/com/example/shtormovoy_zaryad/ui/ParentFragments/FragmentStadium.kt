package com.example.shtormovoy_zaryad.ui.ParentFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shtormovoy_zaryad.R
import com.example.shtormovoy_zaryad.ViewModel.StadiumsViewModel

class FragmentStadium(): Fragment() {

    private lateinit var stadiumId: String
    private var stadiumViewModel = StadiumsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_for_one_stadium_recycler_view, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        stadiumId = arguments?.getString("StadiumId").toString()
        Log.d("VLADIMIR", "$stadiumId в FragmentStadium принято")
        setStadiumData(view)
    }

    fun setStadiumData(stadiumView: View) {
        val dataStadium = stadiumViewModel.getStadiumData(stadiumId)
        Log.d("VLADIMIR", "$stadiumId в FragmentStadium при отображении данных стадиона")

        val textMark: TextView = stadiumView.findViewById(R.id.id_mark_text_stadium_recyclerview)
        val textCount: TextView = stadiumView.findViewById(R.id.id_countpeople_text_stadium_recyclerview)
        val textName: TextView = stadiumView.findViewById(R.id.id_name_stadium_recyclerview)
        val mark: TextView = stadiumView.findViewById(R.id.id_mark_stadium_recyclerview)
        val countPeople: TextView = stadiumView.findViewById(R.id.id_countpeople_stadium_recyclerview)
        val photoStadium: ImageView = stadiumView.findViewById(R.id.id_photo_stadium_recyclerview)

        textMark.setText(R.string.textForMarkTextView)
        textCount.setText(R.string.textForCountPeopleTextView)
        mark.text = dataStadium.mark.toString()
        countPeople.text = dataStadium.countPeople.toString()
        textName.text = dataStadium.stadiumName
        photoStadium.setImageResource(R.drawable.photo_pole_2)
    }
}