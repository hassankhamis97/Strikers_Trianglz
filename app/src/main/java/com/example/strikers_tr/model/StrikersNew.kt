package com.example.strikers_tr.model

class StrikersNew(
    var title: String,
    var image: Int,
    var date: String
): HomeData() {
    override fun getType(): Int {
        return TYPE_STRIKERS_NEWS
    }
}