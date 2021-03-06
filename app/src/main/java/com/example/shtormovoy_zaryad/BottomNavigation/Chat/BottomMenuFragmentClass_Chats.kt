package com.example.shtormovoy_zaryad.BottomNavigation.Chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shtormovoy_zaryad.R

class BottomMenuFragmentClass_Chats : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_navigation_menu_layout_chats, container, false)
        return view
    }
}