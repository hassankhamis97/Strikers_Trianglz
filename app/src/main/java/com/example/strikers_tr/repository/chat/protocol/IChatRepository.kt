package com.example.strikers_tr.repository.chat.protocol

import com.example.strikers_tr.model.chat.Message


interface IChatRepository {
    suspend fun fetchMessages(): ArrayList<Message>
    suspend fun fetchQuickMessages(): ArrayList<String>
}
