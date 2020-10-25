package com.example.strikers_tr.views.gamedetail.fragments.community.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemCommunityGameDetailsBinding
import com.example.strikers_tr.databinding.ItemStrikersNewBinding
import com.example.strikers_tr.model.Community
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.views.gamedetail.fragments.news.adapter.NewsGameDetailAdapter

class CommunityGameDetailAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var communitiesList = ArrayList<Community>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = DataBindingUtil.inflate<ItemCommunityGameDetailsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_community_game_details, parent, false
        )
        return CommunitiesViewHolder(binding)
    }

    override fun getItemCount(): Int  = communitiesList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommunitiesViewHolder) {
            holder.bind(communitiesList[position])
        }
    }

    inner class CommunitiesViewHolder(private val binding: ItemCommunityGameDetailsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(community: Community) {

            binding.apply {
                this.community = community
            }
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("communitiesData")
        fun RecyclerView.bindItems(items: MutableLiveData<ArrayList<Community>>) {
            val adapter = adapter as CommunityGameDetailAdapter
            items.observeForever {
                adapter.communitiesList = it
                adapter.notifyDataSetChanged()
            }
        }
    }

}