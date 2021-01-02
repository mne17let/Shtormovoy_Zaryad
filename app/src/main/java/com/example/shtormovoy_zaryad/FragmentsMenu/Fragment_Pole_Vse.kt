package com.example.shtormovoy_zaryad.FragmentsMenu

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shtormovoy_zaryad.HelpClasses.Singleton_Pole
import com.example.shtormovoy_zaryad.MainActivity
import com.example.shtormovoy_zaryad.R
import com.example.shtormovoy_zaryad.RecyclerView_Pole.Data_Pole
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_pole_vse.*
import kotlinx.android.synthetic.main.fragment_pole_vse.view.*

/*
class Fragment_Pole_Vse : Fragment(R.layout.fragment_pole_vse), OnPoleVseCklick {

    */
/*val adapter = Pole_Adapter(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rec_view_vse_fields.adapter = adapter
        rec_view_vse_fields.layoutManager = LinearLayoutManager(activity)


        Singleton_Pole.getLiveFields().observe(viewLifecycleOwner, Observer {
            adapter.fields = it
        })


    }

    override fun onPoleClick(pole: Data_Pole, position: Int) {

    }*//*


}*/
