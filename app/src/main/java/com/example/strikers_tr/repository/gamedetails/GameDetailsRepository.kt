package com.example.strikers_tr.repository.gamedetails

import com.example.strikers_tr.model.*
import com.example.strikers_tr.model.gamedetails.*
import com.example.strikers_tr.repository.gamedetails.remote.GameDetailRemoteLayer
import kotlinx.coroutines.*

class GameDetailsRepository private constructor(){

    companion object {
        val instance by lazy {
            GameDetailsRepository()
        }
    }
    val gameDetailRemoteLayer by lazy {
        GameDetailRemoteLayer()
    }
//    suspend fun fetchGameDetailsData(): ArrayList<GameDetailsData> = withContext(Dispatchers.IO){
//        if (true) { // simulate that i check for internet connection
//            return@withContext getData(gameDetailRemoteLayer)
//        } else {
//            return@withContext getData(gameDetailRemoteLayer)
//        }
//    }

//    suspend fun getData(dataLayer: IGameDetailRepository): ArrayList<GameDetailsData> = withContext(Dispatchers.IO){
//        var gameDetailsData = ArrayList<GameDetailsData>()
//        launch {
//            gameDetailsData.add(TopPartGameDeatails())
//            gameDetailsData.add(TabBarGameDeatails())
//            gameDetailsData.addAll(dataLayer.fetchTournamentSections())
//        }
//        return@withContext gameDetailsData
//    }

    suspend fun fetchTournament(): ArrayList<TournamentSection> = withContext(Dispatchers.IO){
        return@withContext gameDetailRemoteLayer.fetchTournamentSections()
    }
    suspend fun fetchComunity(): ArrayList<Community> = withContext(Dispatchers.IO){
        return@withContext gameDetailRemoteLayer.fetchComunity()
    }
    suspend fun fetchNews(): ArrayList<StrikersNew> = withContext(Dispatchers.IO){
        return@withContext gameDetailRemoteLayer.fetchNews()
    }

    suspend fun fetchTopPlayersDetailsData(): TopPlayers  = withContext(Dispatchers.IO){
        return@withContext gameDetailRemoteLayer.fetchTopPlayersDetailsData()
    }
}