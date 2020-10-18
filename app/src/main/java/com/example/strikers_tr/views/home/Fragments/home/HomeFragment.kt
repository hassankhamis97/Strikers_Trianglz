package com.example.strikers_tr.views.home.Fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.model.GameType
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.model.TopGame

class HomeFragment: Fragment() {
    lateinit var root: View
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    var topGames = listOf<TopGame>(
        TopGame("Call of duty",GameType.Playstation,R.drawable.call_of_duty,"1,560"),
        TopGame("Pubg",GameType.Mobile,R.drawable.pubg,"2,860"))
    var strickersNews = listOf<StrikersNew>(
        StrikersNew("Social video games to play during the coronavirus quarantine",R.drawable.social_games_two,"22 June 2020"),
        StrikersNew("The Verge's gaming section brings the latest video game news",R.drawable.social_games,"22 June 2020"),
        StrikersNew("Social video games to play during the coronavirus quarantine",R.drawable.pes,"22 June 2020"))
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false) as View
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerTopGamesAdapter()
        registerStrikersNewsAdapter()
    }
    private fun registerTopGamesAdapter() {
        val topGamesSection = root.findViewById<ConstraintLayout>(R.id.topGames_section)
        topGamesSection.findViewById<TextView>(R.id.sectionName_textView).text = topGamesSection.context.getString(R.string.top_games)
        val recyclerView = topGamesSection.findViewById<RecyclerView>(R.id.games_recyclerView)
        val mLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.adapter = SectionalAdapter(topGames.toTypedArray(),true)
    }

    private fun registerStrikersNewsAdapter() {
        val strikersNewsSection = root.findViewById<ConstraintLayout>(R.id.strikersNews_section)
        strikersNewsSection.findViewById<TextView>(R.id.sectionName_textView).text = strikersNewsSection.context.getString(R.string.strikers_news)
        strikersNewsSection.findViewById<TextView>(R.id.viewAll_textView).visibility = View.GONE
        val recyclerView = strikersNewsSection.findViewById<RecyclerView>(R.id.games_recyclerView)
        val mLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        mLayoutManager.canScrollVertically()
        recyclerView.layoutManager = mLayoutManager
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.adapter = SectionalAdapter(strickersNews.toTypedArray(),false)
    }

}