package com.example.strikers_tr.model

abstract class HomeData {
    val TYPE_TOP_GAME = 0
    val TYPE_STRIKERS_NEWS = 1

    abstract fun getType(): Int
}