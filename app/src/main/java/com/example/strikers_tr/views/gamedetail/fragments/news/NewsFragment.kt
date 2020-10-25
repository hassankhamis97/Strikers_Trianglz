package com.example.strikers_tr.views.gamedetail.fragments.news

import android.os.Bundle
import android.service.media.MediaBrowserService
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.FragmentNewsGameDetailsBinding
import com.example.strikers_tr.databinding.FragmentTournamentGameDetailsBinding
import com.example.strikers_tr.views.gamedetail.adapter.GameDetailAdapter
import com.example.strikers_tr.views.gamedetail.fragments.news.adapter.NewsGameDetailAdapter
import com.example.strikers_tr.views.gamedetail.fragments.tournament.TournamentViewModel

class NewsFragment: Fragment() {
    lateinit var root: View
    val newsGameDetails_rectclerView by lazy {
        root.findViewById<RecyclerView>(R.id.newsGameDetails_rectclerView)
    }
    val newsViewModel by lazy {
        ViewModelProvider(this).get(NewsViewModel::class.java)
    }
    val adapter by lazy {
        NewsGameDetailAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNewsGameDetailsBinding>(
            inflater, R.layout.fragment_news_game_details, container, false
        )
        binding.apply {
            this.newsVM = newsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        root = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.fetchNews()
        setupAdapter()
    }
    private fun setupAdapter() {
        val layoutManagerGD = LinearLayoutManager(requireContext())

        newsGameDetails_rectclerView.layoutManager = layoutManagerGD
        newsGameDetails_rectclerView.adapter = adapter


    }
}