package com.example.strikers_tr.repository.home.local

import com.example.strikers_tr.R
import com.example.strikers_tr.model.*
import com.example.strikers_tr.repository.home.protocol.IHomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeLocalLayer: IHomeRepository {
    override suspend fun fetchTopGames(): TopGames = withContext(Dispatchers.IO) {
        var topgamesList = listOf<Game>(
            Game("Call of duty", GameType.Playstation, R.drawable.call_of_duty,"1,560"),
            Game("Pubg", GameType.Mobile, R.drawable.pubg,"2,860")
        )
        var topGamesArr = ArrayList<Game>()
        topgamesList.toCollection(topGamesArr)
        var topGames = TopGames(topGamesArr)

        return@withContext topGames
    }

    override suspend fun fetchStrikersNews(): List<StrikersNew> = withContext(Dispatchers.IO){
        var strickersNews = listOf(
            StrikersNew("Social video games to play during the coronavirus quarantine",
                R.drawable.social_games_two,"22 June 2020",true),
            StrikersNew("The Verge's gaming section brings the latest video game news",
                R.drawable.social_games,"22 June 2020",false),
            StrikersNew("Social video games to play during the coronavirus quarantine",
                R.drawable.pes,"22 June 2020",false)
        )
        return@withContext strickersNews
    }

    override suspend fun fetchFriendRequests(): FriendRequests = withContext(Dispatchers.IO) {
        var friendRequestsList = listOf(
            FriendReqModel("Amelia", R.drawable.player,"1,560"),
            FriendReqModel("Hassan", R.drawable.pubg,"1,560"),
            FriendReqModel("Amelia", R.drawable.call_of_duty,"1,560")
        )
        var friendRequestsArr = ArrayList<FriendReqModel>()
        friendRequestsList.toCollection(friendRequestsArr)
        var friendRequests = FriendRequests(friendRequestsArr)

        return@withContext friendRequests
    }
}