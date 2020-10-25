package com.example.strikers_tr.views.home.fragments.messages.chat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.*
import com.example.strikers_tr.model.HomeData
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.model.chat.Message
import com.example.strikers_tr.views.home.fragments.home.adapters.HomeSectionalAdapter
import com.example.strikers_tr.views.home.fragments.messages.chat.ChatActivity.Companion.accoutPlayer

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var messages: ArrayList<Message> = ArrayList()

    val MESSAGE_FIRST_SEND = 1
    val MESSAGE_FIRST_RECEIVE = 2
    val MESSAGE_SEND = 3
    val MESSAGE_RECEIVE = 4

    override fun getItemViewType(position: Int): Int {
        return when {
             ((messages.size > (position + 1) && messages[position].sender.id != messages[position + 1].sender.id) || (messages.size == (position + 1))) && messages[position].sender.id == accoutPlayer.id -> {
                MESSAGE_FIRST_SEND
            }
            ((messages.size > (position + 1) && messages[position].sender.id != messages[position + 1].sender.id) || (messages.size == (position + 1))) && messages[position].sender.id != accoutPlayer.id -> {
                MESSAGE_FIRST_RECEIVE
            }
            messages[position].sender.id == accoutPlayer.id -> {
                MESSAGE_SEND
            }
            else -> {
                MESSAGE_RECEIVE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        val binding =  when (viewType) {
            MESSAGE_FIRST_SEND -> {
                //            val view = layoutInflater!!.inflate(R.layout.item_strikers_new, parent, false)
                 DataBindingUtil.inflate<ItemTextSendFirstMessageChatBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_text_send_first_message_chat, parent, false
                )
            }
            MESSAGE_SEND -> {
                DataBindingUtil.inflate<ItemTextSendMessageChatBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_text_send_message_chat, parent, false
                )
            }
            MESSAGE_FIRST_RECEIVE -> {
                DataBindingUtil.inflate<ItemTextReceiveFirstMessageChatBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_text_receive_first_message_chat, parent, false
                )
            }
            else -> {
                DataBindingUtil.inflate<ItemTextReceiveMessageChatBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_text_receive_message_chat, parent, false
                )
            }
        }
        return MessageTextViewHolder(binding = binding)
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MessageTextViewHolder -> {
                holder.bind(messages[position])
            }
        }
    }
    inner class MessageTextViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.apply {
                when(binding) {
                    is ItemTextSendFirstMessageChatBinding -> {
                        (this as ItemTextSendFirstMessageChatBinding).message = item
                    }
                    is ItemTextSendMessageChatBinding -> {
                        (this as ItemTextSendMessageChatBinding).message = item
                    }
                    is ItemTextReceiveFirstMessageChatBinding -> {
                        (this as ItemTextReceiveFirstMessageChatBinding).message = item
                    }
                    is ItemTextReceiveMessageChatBinding -> {
                        (this as ItemTextReceiveMessageChatBinding).message = item
                    }
                }

                executePendingBindings()
            }
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("chatMessages")
        fun RecyclerView.bindItems(items: MutableLiveData<ArrayList<Message>>) {
            val adapter = adapter as ChatAdapter
            items.observeForever {
                adapter.messages = it
                adapter.notifyDataSetChanged()
                scrollToPosition(0)
            }
        }
    }
}
