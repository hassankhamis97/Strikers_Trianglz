package com.example.strikers_tr.views.home.fragments.messages.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemQuickMessageBinding
import com.example.strikers_tr.model.Player
import com.example.strikers_tr.views.home.fragments.messages.chat.ChatActivity
import com.example.strikers_tr.views.home.fragments.messages.chat.ChatActivity.Companion.accoutPlayer
import com.example.strikers_tr.views.home.fragments.messages.chat.protocols.IChatView

class QuickMessagesAdapter(val iChatView: IChatView) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var quickMessages: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemQuickMessageBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_quick_message, parent, false
        )
        return QuickMessagesViewHolder(binding)
    }

    inner class QuickMessagesViewHolder(private val binding: ItemQuickMessageBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(message: String) {
            binding.apply {
                this.quikMessage = message
            }
            itemView.setOnClickListener{
                iChatView.sendMessage(message, accoutPlayer)
            }
        }

    }

    override fun getItemCount(): Int = quickMessages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? QuickMessagesViewHolder)?.bind(quickMessages[position])
    }

    companion object {
        @JvmStatic
        @BindingAdapter("quikMessages")
        fun RecyclerView.bindItems(items: MutableLiveData<ArrayList<String>>) {
            val adapter = adapter as QuickMessagesAdapter
            items.observeForever {
                adapter.quickMessages = it
                adapter.notifyDataSetChanged()
            }
        }
    }
}
