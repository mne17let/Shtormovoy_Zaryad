package com.example.shtormovoy_zaryad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shtormovoy_zaryad.R

class Fragment_Chats_BottomMenu : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_chats_fragment_bottom_menu, container, false)
        return view
    }
}