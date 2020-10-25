package com.example.strikers_tr.repository.home.protocol

import com.example.strikers_tr.model.FriendRequests
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.model.TopGames

interface IHomeRepository {
    suspend fun fetchTopGames(): TopGames
    suspend fun fetchStrikersNews(): List<StrikersNew>
    suspend fun fetchFriendRequests(): FriendRequests
}