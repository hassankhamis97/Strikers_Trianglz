package com.example.strikers_tr.views.gamedetail.protocols

import android.content.Context


interface IGameDetailsTabBar {
//    fun addOnChangeTabLisener(tabLayout: TabLayout)
    fun onTabUnselected(context: Context, name: String)
    fun onTabSelected(context: Context, name: String)
}