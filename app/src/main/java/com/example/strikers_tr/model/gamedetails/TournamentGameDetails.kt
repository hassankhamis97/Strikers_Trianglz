package com.example.strikers_tr.model.gamedetails

import com.example.strikers_tr.model.Tournament

//abstract class TournamentData {
//    companion object {
//        var TYPE_OPENING_SOON = 2000
//        var TYPE_ONGOING = 2001
//        val TYPE_COMPLETED = 2002
//    }
//
//    abstract fun getType(): Int
//}

//class TournamentGameDetails(
//        var tournaments: ArrayList<TournamentData>,
//        var isLoad: Boolean
//): GameDetailsData() {
//    override fun getType(): Int {
//        return TYPE_TOURNAMENT
//    }
//    fun test(){
//        var gameDetailsData = ArrayList<GameDetailsData>()
//        gameDetailsData.add(TournamentGameDetails())
//    }
//}

class TournamentSection (
        var values: ArrayList<Tournament>,
        var sectionName: String
): GameDetailsData() {
    override fun getType() = TYPE_TOURNAMENT
}
//
//class OngoingTournament (
//        var ongoing: ArrayList<Tournament>,
//        private var sectionName: String = "Ongoing"
//): GameDetailsData() {
//    override fun getType() = TYPE_TOURNAMENT
//    fun getSectionName(): String = sectionName
//}
//
//class CompletedTournament (
//        var completed: ArrayList<Tournament>,
//        private var sectionName: String = "Completed"
//): GameDetailsData() {
//    override fun getType() = TYPE_TOURNAMENT
//    fun getSectionName(): String = sectionName
//}

//class OpeningSoonTournament (
//        var openingSoon: ArrayList<Tournament>
//): TournamentData() {
//    override fun getType() = TYPE_OPENING_SOON
//}
//
//class OngoingTournament (
//        var ongoing: ArrayList<TournamentData>
//): TournamentData() {
//    override fun getType() = TYPE_ONGOING
//}
//
//class CompletedTournament (
//        var completed: ArrayList<TournamentData>
//): TournamentData() {
//    override fun getType() = TYPE_COMPLETED
//}