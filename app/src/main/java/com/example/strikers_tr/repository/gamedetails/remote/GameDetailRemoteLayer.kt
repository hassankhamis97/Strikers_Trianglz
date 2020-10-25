package com.example.strikers_tr.repository.gamedetails.remote

import com.example.strikers_tr.R
import com.example.strikers_tr.model.*
import com.example.strikers_tr.model.gamedetails.TopPlayers
import com.example.strikers_tr.model.gamedetails.TournamentSection
import com.example.strikers_tr.repository.gamedetails.protocol.IGameDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameDetailRemoteLayer: IGameDetailRepository {
    override suspend fun fetchTournamentSections(): ArrayList<TournamentSection> = withContext(Dispatchers.IO) {
        val tournamentSections = ArrayList<TournamentSection>()
        tournamentSections.add(fetchOpeningSoonSection())
        tournamentSections.add(fetchOngoingSection())
        tournamentSections.add(fetchCompletedSection())
        return@withContext tournamentSections
    }

    private suspend fun fetchOpeningSoonSection(): TournamentSection = withContext(Dispatchers.IO) {
        var tournaments = ArrayList<Tournament> (listOf(
                Tournament("First OS", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0),
                Tournament("Second OS", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0),
                Tournament("Third OS", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0),
                Tournament("Forth OS", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0)
        ))
        val tournamentSection = TournamentSection(tournaments,"Opening soon")
        return@withContext tournamentSection
    }

    private suspend fun fetchOngoingSection(): TournamentSection = withContext(Dispatchers.IO) {
        var tournaments = ArrayList<Tournament> (listOf(
                Tournament("First Ongoing", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0),
                Tournament("Second Ongoing", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0),
                Tournament("Third Ongoing", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0),
                Tournament("Forth Ongoing", R.drawable.pubg,GameType.Mobile,5600,"22 June, 2020","",0)
        ))
        val tournamentSection = TournamentSection(tournaments,"Ongoing")
        return@withContext tournamentSection
    }

    private suspend fun fetchCompletedSection(): TournamentSection = withContext(Dispatchers.IO) {
        var tournaments = ArrayList<Tournament> (listOf(
                Tournament("First Completed", R.drawable.pubg,GameType.Mobile,5600,"","Hassan",R.drawable.player2),
                Tournament("Second Completed", R.drawable.pubg,GameType.Mobile,5600,"","Hassan",R.drawable.player2),
                Tournament("Third Completed", R.drawable.pubg,GameType.Mobile,5600,"","Hassan",R.drawable.player2),
                Tournament("Forth Completed", R.drawable.pubg,GameType.Mobile,5600,"","Hassan",R.drawable.player2)
        ))
        val tournamentSection = TournamentSection(tournaments,"Completed")
        return@withContext tournamentSection
    }
    override suspend fun fetchComunity(): ArrayList<Community> = withContext(Dispatchers.IO) {
        var comunities = ArrayList<Community> (listOf(
                Community("Hassan",R.drawable.player2,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut pretium pretium tempor. arcu aliquet, molestie justo at, auctor nunc. Phasellus ligula ipsum, volutpat eget semper id, viverra eget nibh. Suspendisse luctus mattis cursus. Nam consectetur ante at nisl hendrerit gravida. Donec vehicula rhoncus mattis. Mauris dignissim semper mattis. Fusce porttitor a mi at suscipit. Praesent facilisis dolor sapien, vel sodales augue mollis ut. Mauris venenatis magna eu tortor posuere luctus. Aenean tincidunt turpis sed dui aliquam vehicula. Praesent nec elit non dolor consectetur tincidunt sed in felis. Donec elementum, lacus at mattis tincidunt, eros magna faucibus sem, in condimentum est augue tristique risus.","22 June 2020",460,89,true),
                Community("Hassan",R.drawable.player2,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut pretium pretium tempor. arcu aliquet, molestie justo at, auctor nunc. Phasellus ligula ipsum, volutpat eget semper id, viverra eget nibh. Suspendisse luctus mattis cursus. Nam consectetur ante at nisl hendrerit gravida. Donec vehicula rhoncus mattis. Mauris dignissim semper mattis. Fusce porttitor a mi at suscipit. Praesent facilisis dolor sapien, vel sodales augue mollis ut. Mauris venenatis magna eu tortor posuere luctus. Aenean tincidunt turpis sed dui aliquam vehicula. Praesent nec elit non dolor consectetur tincidunt sed in felis. Donec elementum, lacus at mattis tincidunt, eros magna faucibus sem, in condimentum est augue tristique risus.","22 June 2020",460,8960,false),
                Community("Hassan",R.drawable.player2,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut pretium pretium tempor. arcu aliquet, molestie justo at, auctor nunc. Phasellus ligula ipsum, volutpat eget semper id, viverra eget nibh. Suspendisse luctus mattis cursus. Nam consectetur ante at nisl hendrerit gravida. Donec vehicula rhoncus mattis. Mauris dignissim semper mattis. Fusce porttitor a mi at suscipit. Praesent facilisis dolor sapien, vel sodales augue mollis ut. Mauris venenatis magna eu tortor posuere luctus. Aenean tincidunt turpis sed dui aliquam vehicula. Praesent nec elit non dolor consectetur tincidunt sed in felis. Donec elementum, lacus at mattis tincidunt, eros magna faucibus sem, in condimentum est augue tristique risus.","22 June 2020",460,89,false),
                Community("Hassan",R.drawable.player2,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut pretium pretium tempor. arcu aliquet, molestie justo at, auctor nunc. Phasellus ligula ipsum, volutpat eget semper id, viverra eget nibh. Suspendisse luctus mattis cursus. Nam consectetur ante at nisl hendrerit gravida. Donec vehicula rhoncus mattis. Mauris dignissim semper mattis. Fusce porttitor a mi at suscipit. Praesent facilisis dolor sapien, vel sodales augue mollis ut. Mauris venenatis magna eu tortor posuere luctus. Aenean tincidunt turpis sed dui aliquam vehicula. Praesent nec elit non dolor consectetur tincidunt sed in felis. Donec elementum, lacus at mattis tincidunt, eros magna faucibus sem, in condimentum est augue tristique risus.","22 June 2020",460,89,true)
        ))
        return@withContext comunities
    }

    override suspend fun fetchNews(): ArrayList<StrikersNew> = withContext(Dispatchers.IO) {
        var news = ArrayList<StrikersNew> (listOf(
                StrikersNew("Social video games to play during the coronavirus quarantine",R.drawable.pes,"22 June 2020",false),
                StrikersNew("Social video games to play during the coronavirus quarantine",R.drawable.pes,"22 June 2020",false),
                StrikersNew("Social video games to play during the coronavirus quarantine",R.drawable.pes,"22 June 2020",false),
                StrikersNew("Social video games to play during the coronavirus quarantine",R.drawable.pes,"22 June 2020",false),
                StrikersNew("Social video games to play during the coronavirus quarantine",R.drawable.pes,"22 June 2020",false)
        ))
        return@withContext news
    }

    override suspend fun fetchTopPlayersDetailsData(): TopPlayers = withContext(Dispatchers.IO) {
        val players = ArrayList<Player> (listOf(
            Player("0","Ahmed",R.drawable.player),
            Player("1","Ahmed",R.drawable.player2 ),
            Player("2","Mohamed",R.drawable.player)
        ))
        return@withContext TopPlayers(players = players)

    }
}
