package com.example.strikers_tr.views.gamedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ActivityChatBinding
import com.example.strikers_tr.databinding.ActivityGameDetailBinding
import com.example.strikers_tr.views.gamedetail.adapter.GameDetailAdapter
import com.example.strikers_tr.views.gamedetail.protocols.IChangeTabs
import com.example.strikers_tr.views.home.fragments.messages.chat.ChatViewModel
import com.example.strikers_tr.views.home.fragments.messages.chat.adapter.ChatAdapter
import kotlinx.coroutines.launch

class GameDetailActivity : AppCompatActivity(), IChangeTabs {
    val gameDetails_rectclerView by lazy {
        findViewById<RecyclerView>(R.id.gameDetails_rectclerView)
    }
    val adapter by lazy {
        GameDetailAdapter(this)
    }
    val gameDetailsViewModel by lazy {
        ViewModelProvider(this).get(GameDetailsViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_game_detail)
        val binding = DataBindingUtil.setContentView<ActivityGameDetailBinding>(this, R.layout.activity_game_detail)
        binding.apply {
            this.gameDetailsVM = gameDetailsViewModel
        }
        setupAdapter()
        gameDetailsViewModel.fetchGameDetailsData()
    }
    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(this)

        gameDetails_rectclerView.layoutManager = layoutManager
        gameDetails_rectclerView.adapter = adapter
    }

    override fun fetchTournament() {
        lifecycleScope.launch {
            gameDetailsViewModel.fetchTournament()
        }
    }

    override fun fetchComunity() {
        lifecycleScope.launch {
            gameDetailsViewModel.fetchComunity()
        }
    }

    override fun fetchNews() {
        lifecycleScope.launch {
            gameDetailsViewModel.fetchNews()
        }
    }
}