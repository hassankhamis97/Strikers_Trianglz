package com.example.strikers_tr.views.gamedetail.fragments.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.model.News
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.model.gamedetails.TournamentSection
import com.example.strikers_tr.repository.gamedetails.GameDetailsRepository
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    var newsDataLiveData: MutableLiveData<ArrayList<StrikersNew>> = MutableLiveData<ArrayList<StrikersNew>>().apply {
        value = ArrayList()
    }
    private val gameDetailsRepository by lazy {
        GameDetailsRepository.instance
    }

    private fun fillNewsGameDetailsData(tournamentData: ArrayList<StrikersNew>) {
        newsDataLiveData.postValue(tournamentData)
    }

    fun fetchNews() {
        viewModelScope.launch {
            fillNewsGameDetailsData(gameDetailsRepository.fetchNews())
        }
    }

}