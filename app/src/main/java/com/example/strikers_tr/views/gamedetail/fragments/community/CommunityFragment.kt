package com.example.strikers_tr.views.gamedetail.fragments.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.FragmentCommunityGameDetailsBinding
import com.example.strikers_tr.databinding.FragmentNewsGameDetailsBinding
import com.example.strikers_tr.views.gamedetail.fragments.community.adapter.CommunityGameDetailAdapter
import com.example.strikers_tr.views.gamedetail.fragments.news.NewsViewModel
import com.example.strikers_tr.views.gamedetail.fragments.news.adapter.NewsGameDetailAdapter

class CommunityFragment: Fragment() {
    lateinit var root: View
    val communitiesGameDetails_rectclerView by lazy {
        root.findViewById<RecyclerView>(R.id.communitiesGameDetails_rectclerView)
    }
    val communityViewModel by lazy {
        ViewModelProvider(this).get(CommunityViewModel::class.java)
    }
    val adapter by lazy {
        CommunityGameDetailAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCommunityGameDetailsBinding>(
            inflater, R.layout.fragment_community_game_details, container, false
        )
        binding.apply {
            this.communityVM = communityViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        root = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        communityViewModel.fetchComunity()
        setupAdapter()
    }
    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(requireContext())

        communitiesGameDetails_rectclerView.layoutManager = layoutManager
        communitiesGameDetails_rectclerView.adapter = adapter


    }
}