package com.example.strikers_tr.views.home.fragments.home.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemGameBinding
import com.example.strikers_tr.model.Game
import com.example.strikers_tr.views.gamedetail.GameDetailActivity
import com.example.strikers_tr.views.home.fragments.messages.chat.ChatActivity

class TopGamesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var topGamesList: ArrayList<Game> = ArrayList()
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
            itemView.setOnClickListener {
                handleOpenGame()
            }
        }
        private fun handleOpenGame() {
            val chatIntent = Intent(itemView.context, GameDetailActivity::class.java)
            (itemView.context as AppCompatActivity).startActivity(chatIntent)
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