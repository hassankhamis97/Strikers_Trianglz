package com.example.strikers_tr.views.home.fragments.messages.chat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ActivityChatBinding
import com.example.strikers_tr.model.Player
import com.example.strikers_tr.model.chat.Message
import com.example.strikers_tr.views.home.fragments.home.HomeViewModel
import com.example.strikers_tr.views.home.fragments.messages.chat.adapter.ChatAdapter
import com.example.strikers_tr.views.home.fragments.messages.chat.adapter.QuickMessagesAdapter
import com.example.strikers_tr.views.home.fragments.messages.chat.protocols.IChatView
import com.google.android.material.textview.MaterialTextView


class ChatActivity : AppCompatActivity(), IChatView {
    val chatToolbar by lazy {
        findViewById<Toolbar>(R.id.chat_toolbar)
    }
    val chatViewModel by lazy {
        ViewModelProvider(this).get(ChatViewModel::class.java)
    }
    val sendMessage_btn by lazy {
        findViewById<ImageButton>(R.id.sendMessage_btn)
    }
    val message_editText by lazy {
        findViewById<EditText>(R.id.message_editText)
    }
    val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.messages_recyclerView)
    }
    val quikMessages_recyclerView by lazy {
        findViewById<RecyclerView>(R.id.quikMessages_recyclerView)
    }
    val adapter by lazy {
        ChatAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityChatBinding>(this, R.layout.activity_chat)
        binding.apply {
            this.chatVM = chatViewModel
        }
        setupActionBar()
        setupAdapter()
        setupQuickMessagesAdapter()
    }

    override fun onResume() {
        super.onResume()
        chatViewModel.fetchMessages()
        handleSendMessage()

    }

    private fun handleSendMessage() {
        sendMessage_btn.setOnClickListener {
            val senders = listOf(
                    Player("0","Ahmed",R.drawable.player),
                    Player("1","Ahmed",R.drawable.player2 ),
                    Player("2","Mohamed",R.drawable.player)
            )
            sendMessage(message_editText.text.toString(),senders.random())
            message_editText.text.clear()
        }
    }

    private fun setupActionBar() {

        setSupportActionBar(chatToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        chatToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun setupQuickMessagesAdapter() {
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        quikMessages_recyclerView.layoutManager = layoutManager
        quikMessages_recyclerView.adapter = QuickMessagesAdapter(this)
    }

    companion object {
        val accoutPlayer = Player("0","Hassan",R.drawable.player2)
    }

    override fun sendMessage(messageBody: String, sender: Player) {
        if (messageBody.trim().isNotEmpty()) {
            val message = Message(sender, messageBody)
            adapter.messages.add(0, message)
            adapter.notifyItemInserted(0)
            recyclerView.scrollToPosition(0)
        }
    }


}