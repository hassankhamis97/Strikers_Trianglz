package com.example.strikers_tr.model

abstract class HomeData {
    companion object {
        var TYPE_TOP_GAME = 0
        var TYPE_STRIKERS_NEWS = 1
        val TYPE_WELCOME = 2
        val TYPE_FRIEND_REQUEST = 3
    }

    abstract fun getType(): Int
}


class WelcomePlayer():HomeData() {
    override fun getType(): Int {
        return TYPE_WELCOME
    }

}