package com.example.strikers_tr.views.home.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemGameBinding
import com.example.strikers_tr.model.Game

class TopGamesAdapter(var topGamesList: ArrayList<Game>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemGameBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_game, parent, false
        )
        return GameViewHolder(binding)
    }

    inner class GameViewHolder(private val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Game){
            binding.apply {
                game = item
                executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int = topGamesList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GameViewHolder) {
            holder.bind(topGamesList[position])
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("gameList")
        fun RecyclerView.bindItems(items: ArrayList<Game>) {
            val adapter = adapter as TopGamesAdapter
            adapter.topGamesList = items
            adapter.notifyDataSetChanged()
        }
    }
}