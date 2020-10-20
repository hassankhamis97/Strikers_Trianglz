package com.example.strikers_tr.views.home.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.model.HomeData
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.model.TopGames
import com.example.strikers_tr.model.WelcomePlayer
import com.example.strikers_tr.repository.home.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {
    var homeDataLiveData: MutableLiveData<ArrayList<HomeData>> = MutableLiveData<ArrayList<HomeData>>().apply {
        value = ArrayList()
    }
    val isLoadingData = MutableLiveData<Boolean>()

    private val homeRepository by lazy {
        HomeRepository()
    }
    fun fetchHomeData() {
        viewModelScope.launch {
            isLoadingData.postValue(true)
            fillHomeData(homeRepository.fetchHomeData())
        }
    }

    private fun fillHomeData(homeData: java.util.ArrayList<HomeData>) {
        homeDataLiveData.postValue(homeData)
        isLoadingData.postValue(false)
    }

}