package com.example.strikers_tr.repository.chat.remote

import com.example.strikers_tr.R
import com.example.strikers_tr.model.Player
import com.example.strikers_tr.model.chat.Message
import com.example.strikers_tr.repository.chat.protocol.IChatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChatRemoteLayer: IChatRepository {
    override suspend fun fetchMessages(): ArrayList<Message> = withContext(Dispatchers.IO){
        var messages = ArrayList<Message>()
        messages.addAll(
            listOf(
                Message(Player("0","Ahmed",R.drawable.player),"Good"),
                Message(Player("1","Ahmed",R.drawable.player2 ),"Thanks"),
                Message(Player("2","Mohamed",R.drawable.player),"helllllo"),
                Message(Player("0","Hassan",R.drawable.player2),"and you?"),
                Message(Player("0","Hassan",R.drawable.player2),"Good"),
                Message(Player("0","Hassan",R.drawable.player2),"Welcome"),
                Message(Player("1","Ahmed",R.drawable.player2 ),"How are you?"),
                Message(Player("1","Ahmed",R.drawable.player2 ),"Hello")
            )
        )
        return@withContext messages
    }

    override suspend fun fetchQuickMessages(): ArrayList<String> = withContext(Dispatchers.IO) {
        val quickMessage = ArrayList<String>()
        quickMessage.addAll(
                listOf(
                        "Hello, Strikers \uD83D\uDC4B","I'm inviting you to join..\uD83C\uDFC6", "Hello, Strikers \uD83D\uDC4B"
                )
        )
        return@withContext quickMessage
    }
}