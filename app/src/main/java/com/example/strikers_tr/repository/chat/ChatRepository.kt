package com.example.strikers_tr.repository.chat


import com.example.strikers_tr.model.chat.Message
import com.example.strikers_tr.repository.chat.protocol.IChatRepository
import com.example.strikers_tr.repository.chat.remote.ChatRemoteLayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ChatRepository {
    val chatRemoteLayer by lazy {
        ChatRemoteLayer()
    }
    suspend fun fetchMessages(): ArrayList<Message> = withContext(Dispatchers.IO){
        if (true) { // simulate that i check for internet connection
            return@withContext getData(chatRemoteLayer)
        } else {
            return@withContext getData(chatRemoteLayer)
        }
    }

    suspend fun getData(dataLayer: IChatRepository): ArrayList<Message> = withContext(Dispatchers.IO){
        var messages = ArrayList<Message>()
        async {
            messages = dataLayer.fetchMessages()
        }.await()
        return@withContext messages
    }

    suspend fun fetchQuickMessages(): ArrayList<String> = withContext(Dispatchers.IO) {
        return@withContext chatRemoteLayer.fetchQuickMessages()
    }
}
