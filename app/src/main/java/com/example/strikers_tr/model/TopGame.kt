package com.example.strikers_tr.model

class TopGame(
    var name: String,
    var gameType: GameType,
    var image: Int,
    var followersNo: String
): HomeData() {
    override fun getType(): Int {
        return TYPE_TOP_GAME
    }
}

enum class GameType {
    Playstation,
    Mobile
}