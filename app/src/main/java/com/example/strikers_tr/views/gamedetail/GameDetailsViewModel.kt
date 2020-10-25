package com.example.strikers_tr.views.gamedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.model.gamedetails.TopPlayers
import com.example.strikers_tr.repository.gamedetails.GameDetailsRepository
import kotlinx.coroutines.launch

class GameDetailsViewModel: ViewModel() {

    var topPlayersLiveData: MutableLiveData<TopPlayers> = MutableLiveData<TopPlayers>().apply {
        value?.players = ArrayList()
    }



    private val gameDetailsRepository by lazy {
        GameDetailsRepository.instance
    }

    fun fetchTopPlayersDetailsData() {
        viewModelScope.launch {
            fillTopPlayersDetailsData(gameDetailsRepository.fetchTopPlayersDetailsData())
        }
    }

    private fun fillTopPlayersDetailsData(topPlayers: TopPlayers) {
        topPlayersLiveData.postValue(topPlayers)
    }

}