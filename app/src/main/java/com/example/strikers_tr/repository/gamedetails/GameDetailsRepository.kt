package com.example.strikers_tr.repository.gamedetails

import com.example.strikers_tr.model.*
import com.example.strikers_tr.model.chat.Message
import com.example.strikers_tr.model.gamedetails.GameDetailsData
import com.example.strikers_tr.model.gamedetails.TabBarGameDeatails
import com.example.strikers_tr.model.gamedetails.TopPartGameDeatails
import com.example.strikers_tr.model.gamedetails.TournamentSection
import com.example.strikers_tr.repository.chat.protocol.IChatRepository
import com.example.strikers_tr.repository.chat.remote.ChatRemoteLayer
import com.example.strikers_tr.repository.gamedetails.protocol.IGameDetailRepository
import com.example.strikers_tr.repository.gamedetails.remote.GameDetailRemoteLayer
import com.example.strikers_tr.repository.home.protocol.IHomeRepository
import kotlinx.coroutines.*

class GameDetailsRepository {
    val gameDetailRemoteLayer by lazy {
        GameDetailRemoteLayer()
    }
    suspend fun fetchGameDetailsData(): ArrayList<GameDetailsData> = withContext(Dispatchers.IO){
        if (true) { // simulate that i check for internet connection
            return@withContext getData(gameDetailRemoteLayer)
        } else {
            return@withContext getData(gameDetailRemoteLayer)
        }
    }

    suspend fun getData(dataLayer: IGameDetailRepository): ArrayList<GameDetailsData> = withContext(Dispatchers.IO){
        var gameDetailsData = ArrayList<GameDetailsData>()
        launch {
            gameDetailsData.add(TopPartGameDeatails())
            gameDetailsData.add(TabBarGameDeatails())
            gameDetailsData.addAll(dataLayer.fetchTournamentSections())
        }
        return@withContext gameDetailsData
    }

    suspend fun fetchTournament(): ArrayList<TournamentSection> = withContext(Dispatchers.IO){
        return@withContext gameDetailRemoteLayer.fetchTournamentSections()
    }
    suspend fun fetchComunity(): ArrayList<Comunity> = withContext(Dispatchers.IO){
        return@withContext gameDetailRemoteLayer.fetchComunity()
    }
    suspend fun fetchNews(): ArrayList<News> = withContext(Dispatchers.IO){
        return@withContext gameDetailRemoteLayer.fetchNews()
    }
}