package com.example.strikers_tr.model

import com.example.strikers_tr.model.gamedetails.GameDetailsData

class News(
        var title: String,
        var image: Int,
        var date: String
): GameDetailsData() {
    override fun getType(): Int {
        return TYPE_NEWS
    }
}