package com.example.strikers_tr.views.gamedetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.SectionTournamentGameDetailsBinding
import com.example.strikers_tr.model.gamedetails.TournamentSection
import com.google.android.material.tabs.TabLayout


class GameDetailAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var tournamentSections = ArrayList<TournamentSection>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = DataBindingUtil.inflate<SectionTournamentGameDetailsBinding>(
                LayoutInflater.from(parent.context),
                R.layout.section_tournament_game_details, parent, false
        )
        return TournamentViewHolder(binding)
    }

    override fun getItemCount(): Int  = tournamentSections.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TournamentViewHolder) {
            holder.bind(tournamentSections[position])
        }
    }

    inner class TournamentViewHolder(private val binding: SectionTournamentGameDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        internal val tournament_recyclerView = binding.root.findViewById<RecyclerView>(R.id.tournament_recyclerView)
        val tournamentAdapter by lazy {
            TournamentSectionAdapter()
        }
        init {
            val layoutManager = LinearLayoutManager(tournament_recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            tournament_recyclerView.layoutManager = layoutManager
            tournament_recyclerView.adapter = tournamentAdapter

        }
        fun bind(tournamentSection: TournamentSection) {
            tournamentAdapter.tournamentList = tournamentSection.values
            tournamentAdapter.sectionName = tournamentSection.sectionName
            binding.apply {
                this.tournament = tournamentSection
            }
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("tournamentData")
        fun RecyclerView.bindItems(items: MutableLiveData<ArrayList<TournamentSection>>) {
            val adapter = adapter as GameDetailAdapter
            items.observeForever {
                adapter.tournamentSections = it
                adapter.notifyDataSetChanged()
            }
        }
    }

}
