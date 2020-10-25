package com.example.strikers_tr.views.gamedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemTopPlayersTeamsBinding
import com.example.strikers_tr.databinding.SectionTournamentGameDetailsBinding
import com.example.strikers_tr.model.Player
import com.example.strikers_tr.model.gamedetails.TopPlayers
import com.example.strikers_tr.model.gamedetails.TournamentSection

class TopPlayersGameDetailAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var topPlayers = ArrayList<Player>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemTopPlayersTeamsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_top_players_teams, parent, false
        )
        return TopPlayersViewHolder(binding)
    }

    override fun getItemCount(): Int = topPlayers.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TopPlayersViewHolder) {
            holder.bind(topPlayers[position])
        }
    }
    inner class TopPlayersViewHolder(private val binding: ItemTopPlayersTeamsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            binding.apply {
                this.player = player
                executePendingBindings()
            }
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("topPlayers")
        fun RecyclerView.bindItems(items: MutableLiveData<TopPlayers>) {
            val adapter = adapter as TopPlayersGameDetailAdapter
//            adapter.topPlayers = items.players
            items.observeForever {
                adapter.topPlayers = it.players
                adapter.notifyDataSetChanged()
            }
        }
    }

}
