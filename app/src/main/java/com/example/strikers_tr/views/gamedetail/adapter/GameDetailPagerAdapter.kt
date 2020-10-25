package com.example.strikers_tr.views.gamedetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.strikers_tr.views.gamedetail.fragments.community.CommunityFragment
import com.example.strikers_tr.views.gamedetail.fragments.news.NewsFragment
import com.example.strikers_tr.views.gamedetail.fragments.tournament.TournamentFragment
import com.example.strikers_tr.views.home.fragments.home.HomeFragment
import com.example.strikers_tr.views.home.fragments.messages.MessagesFragment

class GameDetailPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                TournamentFragment()
            }
            1 -> {
                CommunityFragment()
            }
            else -> {
                NewsFragment()
            }
        }
    }
}