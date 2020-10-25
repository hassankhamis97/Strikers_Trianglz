package com.example.strikers_tr.repository.gamedetails.protocol

import com.example.strikers_tr.model.Community
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.model.gamedetails.TopPlayers
import com.example.strikers_tr.model.gamedetails.TournamentSection

interface IGameDetailRepository {
    suspend fun fetchTournamentSections(): ArrayList<TournamentSection>
    suspend fun fetchComunity(): ArrayList<Community>
    suspend fun fetchNews(): ArrayList<StrikersNew>
    suspend fun fetchTopPlayersDetailsData(): TopPlayers
}
