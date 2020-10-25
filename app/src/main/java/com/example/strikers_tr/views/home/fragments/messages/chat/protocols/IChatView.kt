package com.example.strikers_tr.views.home.fragments.messages.chat.protocols

import com.example.strikers_tr.model.Player

interface IChatView {
    fun sendMessage(messageBody: String, sender: Player)
}