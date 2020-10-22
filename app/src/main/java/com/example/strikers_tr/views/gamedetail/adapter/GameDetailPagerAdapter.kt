package com.example.strikers_tr.views.gamedetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.strikers_tr.views.gamedetail.fragments.TournamentFragment
import com.example.strikers_tr.views.home.fragments.home.HomeFragment
import com.example.strikers_tr.views.home.fragments.messages.MessagesFragment
import com.example.strikers_tr.views.home.fragments.teams.TeamsFragment

class GameDetailPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                MessagesFragment()
            }
            else -> {
                TournamentFragment()
            }
        }
    }
}