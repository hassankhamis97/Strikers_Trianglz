package com.example.strikers_tr.views.gamedetail.fragments.tournament

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.model.gamedetails.TournamentSection
import com.example.strikers_tr.repository.gamedetails.GameDetailsRepository
import kotlinx.coroutines.launch

class TournamentViewModel: ViewModel() {
    var tournamentDataLiveData: MutableLiveData<ArrayList<TournamentSection>> = MutableLiveData<ArrayList<TournamentSection>>().apply {
        value = ArrayList()
    }
    private val gameDetailsRepository by lazy {
        GameDetailsRepository.instance
    }

    private fun fillTournamentGameDetailsData(tournamentData: ArrayList<TournamentSection>) {
        tournamentDataLiveData.postValue(tournamentData)
    }

    fun fetchTournament() {
        viewModelScope.launch {
            val tournamentSections = gameDetailsRepository.fetchTournament()
            fillTournamentGameDetailsData(tournamentSections)
        }
    }

}