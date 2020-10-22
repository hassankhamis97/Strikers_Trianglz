package com.example.strikers_tr.repository.gamedetails.protocol

import com.example.strikers_tr.model.Comunity
import com.example.strikers_tr.model.News
import com.example.strikers_tr.model.gamedetails.TournamentSection

interface IGameDetailRepository {
    suspend fun fetchTournamentSections(): ArrayList<TournamentSection>
    suspend fun fetchComunity(): ArrayList<Comunity>
    suspend fun fetchNews(): ArrayList<News>

}
