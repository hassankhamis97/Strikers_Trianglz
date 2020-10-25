package com.example.strikers_tr.views.home.fragments.messages.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.model.HomeData
import com.example.strikers_tr.model.chat.Message
import com.example.strikers_tr.repository.chat.ChatRepository
import com.example.strikers_tr.repository.home.HomeRepository
import kotlinx.coroutines.launch

class ChatViewModel: ViewModel() {
    init {

    }
    var messagesLiveData: MutableLiveData<ArrayList<Message>> = MutableLiveData<ArrayList<Message>>().apply {
        value = ArrayList()
    }
    val quickMessages: MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>().apply {
        value = ArrayList()
    }
    private val chatRepository by lazy {
        ChatRepository()
    }
    fun fetchMessages() {
        viewModelScope.launch {
            fillMessages(chatRepository.fetchMessages())
            fillQuickMessages(chatRepository.fetchQuickMessages())
        }
    }

    private fun fillQuickMessages(quickMessages: ArrayList<String>) {
        this.quickMessages.value = quickMessages
    }

    private fun fillMessages(messages: ArrayList<Message>) {
        messagesLiveData.value = messages
    }
}