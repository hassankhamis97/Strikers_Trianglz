package com.example.strikers_tr.model

class TopGames(
    var topGamesList: ArrayList<Game>
): HomeData() {
    override fun getType(): Int {
        return TYPE_TOP_GAME
    }
}
data class Game(
    var name: String,
    var gameType: GameType,
    var image: Int,
    var followersNo: String
)
enum class GameType {
    Playstation,
    Mobile
}