package com.example.strikers_tr.views.gamedetail.fragments.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemStrikersNewBinding
import com.example.strikers_tr.model.StrikersNew


class NewsGameDetailAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var newsList = ArrayList<StrikersNew>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = DataBindingUtil.inflate<ItemStrikersNewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_strikers_new, parent, false
        )
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int  = newsList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NewsViewHolder) {
            holder.bind(newsList[position])
        }
    }

    inner class NewsViewHolder(private val binding: ItemStrikersNewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(news: StrikersNew) {

            binding.apply {
                this.strikerNew = news
            }
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("newsData")
        fun RecyclerView.bindItems(items: MutableLiveData<ArrayList<StrikersNew>>) {
            val adapter = adapter as NewsGameDetailAdapter
            items.observeForever {
                adapter.newsList = it
                adapter.notifyDataSetChanged()
            }
        }
    }

}
