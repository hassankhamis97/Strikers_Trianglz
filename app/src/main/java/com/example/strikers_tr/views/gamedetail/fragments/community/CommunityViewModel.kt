package com.example.strikers_tr.views.gamedetail.fragments.community

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.strikers_tr.model.Community
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.repository.gamedetails.GameDetailsRepository
import kotlinx.coroutines.launch

class CommunityViewModel: ViewModel() {
    var communitiesDataLiveData: MutableLiveData<ArrayList<Community>> = MutableLiveData<ArrayList<Community>>().apply {
        value = ArrayList()
    }
    private val gameDetailsRepository by lazy {
        GameDetailsRepository.instance
    }

    private fun fillNewsGameDetailsData(communityData: ArrayList<Community>) {
        communitiesDataLiveData.postValue(communityData)
    }

    fun fetchComunity() {
        viewModelScope.launch {
            fillNewsGameDetailsData(gameDetailsRepository.fetchComunity())
        }
    }
}