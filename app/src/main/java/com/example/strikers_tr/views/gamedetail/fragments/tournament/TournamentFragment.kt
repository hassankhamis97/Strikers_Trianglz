package com.example.strikers_tr.views.gamedetail.fragments.tournament

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
import com.example.strikers_tr.databinding.FragmentHomeBinding
import com.example.strikers_tr.databinding.FragmentTournamentGameDetailsBinding
import com.example.strikers_tr.views.gamedetail.GameDetailsViewModel
import com.example.strikers_tr.views.gamedetail.adapter.GameDetailAdapter
import com.example.strikers_tr.views.gamedetail.adapter.TopPlayersGameDetailAdapter

class TournamentFragment: Fragment() {
    lateinit var root: View
    val gameDetails_rectclerView by lazy {
        root.findViewById<RecyclerView>(R.id.gameDetails_rectclerView)
    }
    val tournamentViewModel by lazy {
        ViewModelProvider(this).get(TournamentViewModel::class.java)
    }
    val adapter by lazy {
        GameDetailAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTournamentGameDetailsBinding>(
            inflater, R.layout.fragment_tournament_game_details, container, false
        )
        binding.apply {
            this.tournamentVM = tournamentViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tournamentViewModel.fetchTournament()
        setupAdapter()
    }
    private fun setupAdapter() {
        val layoutManagerGD = LinearLayoutManager(requireContext())

        gameDetails_rectclerView.layoutManager = layoutManagerGD
        gameDetails_rectclerView.adapter = adapter


    }
}