package com.example.strikers_tr.repository.home

import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.R
import com.example.strikers_tr.model.*
import com.example.strikers_tr.repository.home.local.HomeLocalLayer
import com.example.strikers_tr.repository.home.protocol.IHomeRepository
import com.example.strikers_tr.repository.home.remote.HomeRemoteLayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeRepository {
    val homeRemoteLayer by lazy {
        HomeRemoteLayer()
    }
    val homeLocalLayer by lazy {
        HomeLocalLayer()
    }

    suspend fun fetchHomeData(): ArrayList<HomeData> = withContext(Dispatchers.IO){
        if (true) { // simulate that i check for internet connection
            return@withContext getData(homeRemoteLayer)
        } else {
            return@withContext getData(homeLocalLayer)
        }
    }

    suspend fun getData(dataLayer: IHomeRepository): ArrayList<HomeData> = withContext(Dispatchers.IO){
        var homeData = ArrayList<HomeData>()
        launch {
            delay(2000) // make simulation as data get from network
            homeData.add(WelcomePlayer())
            homeData.add(dataLayer.fetchFriendRequests())
            homeData.add(dataLayer.fetchTopGames())
            homeData.addAll(dataLayer.fetchStrikersNews())
        }
        return@withContext homeData
    }

}