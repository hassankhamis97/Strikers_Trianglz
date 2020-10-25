package com.example.strikers_tr.views.gamedetail

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ActivityGameDetailBinding
import com.example.strikers_tr.views.gamedetail.adapter.GameDetailPagerAdapter
import com.example.strikers_tr.views.gamedetail.adapter.TopPlayersGameDetailAdapter
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GameDetailActivity : AppCompatActivity() {

    val topPlayers_recyclerView by lazy {
        findViewById<RecyclerView>(R.id.topPlayers_recyclerView)
    }
    val toolbar_profile by lazy {
        findViewById<Toolbar>(R.id.toolbar_profile)
    }
    val appbar_profile by lazy {
        findViewById<AppBarLayout>(R.id.appbar_profile)
    }
    val adapter by lazy {
        TopPlayersGameDetailAdapter()
    }
//    val adapterGD by lazy {
//        GameDetailAdapter(this)
//    }
    val gameDetailsViewModel by lazy {
        ViewModelProvider(this).get(GameDetailsViewModel::class.java)
    }
    val gameDetails_viewPager by lazy {
        findViewById<ViewPager2>(R.id.gameDetails_viewPager)
    }
    val gameDetails_tabLayout by lazy {
        findViewById<TabLayout>(R.id.gameDetails_tabLayout)
    }
    val gameDetailPagerAdapter by lazy {
        GameDetailPagerAdapter(supportFragmentManager, lifecycle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_game_detail)
        val binding = DataBindingUtil.setContentView<ActivityGameDetailBinding>(this, R.layout.activity_game_detail)
        binding.apply {
            this.gameDetailsVM = gameDetailsViewModel
        }
        setupViewPagerAndTabLayout()
        setupAdapter()
        gameDetailsViewModel.fetchTopPlayersDetailsData()
//        gameDetailsViewModel.fetchGameDetailsData()
    }

    private fun setupViewPagerAndTabLayout() {
        gameDetails_viewPager.isUserInputEnabled = false;
        val TAB_TITLES = listOf<String>(getString(R.string.tournament), getString(R.string.comunity), getString(R.string.news))
        gameDetails_viewPager.adapter = gameDetailPagerAdapter
        // connect the tabs and view pager2
        TabLayoutMediator(gameDetails_tabLayout, gameDetails_viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
            gameDetails_viewPager.setCurrentItem(tab.position, true)
        }.attach()
        gameDetails_tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 1) {

                } else {

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        topPlayers_recyclerView.layoutManager = layoutManager
        topPlayers_recyclerView.adapter = adapter

    }
    
}