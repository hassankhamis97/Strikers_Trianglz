package com.example.strikers_tr.views.gamedetail.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.*
import com.example.strikers_tr.model.Game
import com.example.strikers_tr.model.Tournament
import com.example.strikers_tr.views.gamedetail.GameDetailActivity
import com.example.strikers_tr.views.home.fragments.home.adapters.TopGamesAdapter

class TournamentSectionAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var sectionName = ""
    var tournamentList: ArrayList<Tournament> = ArrayList()
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = when(sectionName) {
            "Opening soon" -> {
                DataBindingUtil.inflate<ItemTournamentOpeningSoonBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.item_tournament_opening_soon, parent, false
                )
            }
            "Ongoing" -> {
                DataBindingUtil.inflate<ItemTournamentOngoingBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.item_tournament_ongoing, parent, false
                )
            }
            else -> {
                DataBindingUtil.inflate<ItemTournamentCompletedBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.item_tournament_completed, parent, false
                )
            }
        }

        return TournamentViewHolder(binding)
    }

    inner class TournamentViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tournament){
            binding.apply {
                when(binding) {
                    is ItemTournamentOpeningSoonBinding -> {
                        (this as ItemTournamentOpeningSoonBinding).tournament = item
                    }
                    is ItemTournamentOngoingBinding -> {
                        (this as ItemTournamentOngoingBinding).tournament = item
                    }
                    is ItemTournamentCompletedBinding -> {
                        (this as ItemTournamentCompletedBinding).tournament = item
                    }
                }
                executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int = tournamentList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TournamentViewHolder) {
            holder.bind(tournamentList[position])
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("tournamentList")
        fun RecyclerView.bindItems(items: ArrayList<Tournament>) {
            val adapter = adapter as TournamentSectionAdapter
            adapter.tournamentList = items
            adapter.notifyDataSetChanged()
        }
    }
}
