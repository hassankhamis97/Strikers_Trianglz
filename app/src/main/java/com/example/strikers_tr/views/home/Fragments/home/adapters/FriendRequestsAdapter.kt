package com.example.strikers_tr.views.home.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemFriendRequestBinding
import com.example.strikers_tr.model.FriendReqModel

class FriendRequestsAdapter(var friendRequestsList: ArrayList<FriendReqModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemFriendRequestBinding>(LayoutInflater.from(parent.context),
                R.layout.item_friend_request, parent, false)
        return FriendRequestsViewHolder(binding)
    }

    inner class FriendRequestsViewHolder(private val binding: ItemFriendRequestBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(friendRequest: FriendReqModel) {
            binding.apply {
                this.friendReq = friendRequest
                executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int = friendRequestsList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is FriendRequestsViewHolder) {
            holder.bind(friendRequestsList[position])
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("friendRequestList")
        fun RecyclerView.bindItems(items: ArrayList<FriendReqModel>) {
            val adapter = adapter as FriendRequestsAdapter
            adapter.friendRequestsList = items
            adapter.notifyDataSetChanged()
        }
    }
}
