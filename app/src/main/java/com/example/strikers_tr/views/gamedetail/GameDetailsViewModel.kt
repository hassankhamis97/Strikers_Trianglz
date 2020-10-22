package com.example.strikers_tr.views.gamedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.model.gamedetails.GameDetailsData
import com.example.strikers_tr.repository.gamedetails.GameDetailsRepository
import kotlinx.coroutines.launch

class GameDetailsViewModel: ViewModel() {
    var gameDetailsDataLiveData: MutableLiveData<ArrayList<GameDetailsData>> = MutableLiveData<ArrayList<GameDetailsData>>().apply {
        value = ArrayList()
    }
//    val isLoadingData = MutableLiveData<Boolean>()

    private val gameDetailsRepository by lazy {
        GameDetailsRepository()
    }
    fun fetchGameDetailsData() {
        viewModelScope.launch {
//            isLoadingData.postValue(true)
            fillGameDetailsData(gameDetailsRepository.fetchGameDetailsData())
        }
    }

    private fun fillGameDetailsData(gameDetailsData: ArrayList<GameDetailsData>) {
        gameDetailsDataLiveData.postValue(gameDetailsData)
//        isLoadingData.postValue(false)
    }

    suspend fun fetchTournament() {
        var gameDetailsData = gameDetailsDataLiveData.value
        for (index in (gameDetailsData?.size!! - 1) downTo 2) {
            gameDetailsData.removeAt(index)
        }
        gameDetailsData.addAll(gameDetailsRepository.fetchTournament())
        fillGameDetailsData(gameDetailsData)
    }

    suspend fun fetchComunity() {
        var gameDetailsData = gameDetailsDataLiveData.value
        for (index in (gameDetailsData?.size!! - 1) downTo 2) {
            gameDetailsData.removeAt(index)
        }
        gameDetailsData.addAll(gameDetailsRepository.fetchComunity())
        fillGameDetailsData(gameDetailsData)
    }

    suspend fun fetchNews() {
        var gameDetailsData = gameDetailsDataLiveData.value
        for (index in (gameDetailsData?.size!! - 1) downTo 2) {
            gameDetailsData.removeAt(index)
        }
        gameDetailsData.addAll(gameDetailsRepository.fetchNews())
        fillGameDetailsData(gameDetailsData)
    }

}