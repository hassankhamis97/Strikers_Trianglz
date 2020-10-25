package com.example.strikers_tr.views.gamedetail

import android.animation.ValueAnimator
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

class GameDetailActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    private var isHideToolbarView = false

    val topPlayers_recyclerView by lazy {
        findViewById<RecyclerView>(R.id.topPlayers_recyclerView)
    }
    val toolbar_profile by lazy {
        findViewById<Toolbar>(R.id.toolbar_profile)
    }
    val appbar_profile by lazy {
        findViewById<AppBarLayout>(R.id.appbar_profile)
    }
    val coordinator by lazy {
        findViewById<CoordinatorLayout>(R.id.co_profile_activity_root_layout)
    }
    val backIV by lazy {
        findViewById<ImageView>(R.id.back_imageView)
    }
    val toolbarBackground_layout  by lazy {
        findViewById<LinearLayout>(R.id.toolbarBackground_layout)
    }

    val adapter by lazy {
        TopPlayersGameDetailAdapter()
    }

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
        initCollapsingToolbarUi()
        setupViewPagerAndTabLayout()
        setupAdapter()
        gameDetailsViewModel.fetchTopPlayersDetailsData()
        backIV.setOnClickListener {
            onBackPressed()
        }
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
    private fun initCollapsingToolbarUi() {
        appbar_profile.addOnOffsetChangedListener(this)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        val maxScroll = appBarLayout!!.totalScrollRange
        val percentage = abs(verticalOffset).toFloat() / maxScroll.toFloat()
        toolbar_profile.title = ""
        Log.i("checkPercentage","${verticalOffset} and percent = $percentage")
        lifecycleScope.launch(Dispatchers.Main) {
            toolbarBackground_layout.animate().alpha((percentage*3))

        }

    }

}