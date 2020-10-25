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