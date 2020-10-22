package com.example.strikers_tr.model

import com.example.strikers_tr.model.gamedetails.GameDetailsData

class Comunity(
        var playerName: String,
        var playerImage: Int,
        var postBody: String,
        var postDate: String,
        var likesNo: Int,
        var disLikeNo: Int,
        var isVerified: Boolean
) : GameDetailsData() {
    override fun getType(): Int {
        return TYPE_COMUNITY
    }
}
