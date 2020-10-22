package com.example.strikers_tr.views.gamedetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemStrikersNewBinding
import com.example.strikers_tr.databinding.SectionTopGamesBinding
import com.example.strikers_tr.databinding.SectionTournamentGameDetailsBinding
import com.example.strikers_tr.model.TopGames
import com.example.strikers_tr.model.chat.Message
import com.example.strikers_tr.model.gamedetails.GameDetailsData
import com.example.strikers_tr.model.gamedetails.TournamentSection
import com.example.strikers_tr.views.gamedetail.protocols.IChangeTabs
import com.example.strikers_tr.views.gamedetail.protocols.IGameDetailsTabBar
import com.example.strikers_tr.views.home.fragments.home.adapters.TopGamesAdapter
import com.example.strikers_tr.views.home.fragments.messages.chat.adapter.ChatAdapter
import com.google.android.material.tabs.TabLayout


class GameDetailAdapter(val iChangeTabs: IChangeTabs): RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    HeaderItemDecoration.StickyHeaderInterface, IGameDetailsTabBar {
    private var gameDetailsData = ArrayList<GameDetailsData>()
    private var layoutInflater: LayoutInflater? = null
    lateinit var tabLayout: TabLayout
    override fun getItemViewType(position: Int): Int {
        return gameDetailsData[position].getType()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        var view: View
        return when (viewType) {
            GameDetailsData.TYPE_TOP_SECTION -> {
                view = layoutInflater!!.inflate(R.layout.item_game_detail_top_part_section, parent, false)
                TopPartViewHolder(view)
            }
            GameDetailsData.TYPE_TAB_BAR_SECTION -> {
                view = layoutInflater!!.inflate(R.layout.item_game_detail_tab_bar_section, parent, false)
                TabBarPartViewHolder(view, this)
            }
            GameDetailsData.TYPE_TOURNAMENT -> {
                val binding = DataBindingUtil.inflate<SectionTournamentGameDetailsBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.section_tournament_game_details, parent, false
                )
                TournamentViewHolder(binding)
            }
//            else -> {
//                view = layoutInflater!!.inflate(R.layout.item_game_detail_last_part_section, parent, false)
//                BottomPartViewHolder(view)
//            }
            else -> {
                view = layoutInflater!!.inflate(R.layout.item_strikers_new, parent, false)
                TopPartViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int  = gameDetailsData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TopPartViewHolder) {
            holder.bind(position)
        } else if (holder is TabBarPartViewHolder) {
            holder.bind(position)
        } else if (holder is TournamentViewHolder) {
            holder.bind(gameDetailsData[position] as TournamentSection)
        }
    }

    inner class TopPartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {

        }
    }

    inner class TabBarPartViewHolder(itemView: View, iGameDetailsTabBar: IGameDetailsTabBar) : RecyclerView.ViewHolder(itemView) {
        val tabLayout = itemView.findViewById<TabLayout>(R.id.gameDetails_tabLayout)
        init {
//            iGameDetailsTabBar.addOnChangeTabLisener(tabLayout)
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                    print(tab)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    onTabUnselected(tabLayout.context ,tab?.text.toString())
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    onTabSelected(tabLayout.context, tab?.text.toString())
                }

            })
        }
        fun bind(position: Int) {

        }
    }
    inner class BottomPartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameDetails_viewPager = itemView.findViewById<ViewPager2>(R.id.gameDetails_viewPager)

        fun bind(position: Int) {
            val activity = (gameDetails_viewPager.context as AppCompatActivity)
            val adapterViewPager = GameDetailPagerAdapter(activity.supportFragmentManager,activity.lifecycle)
            gameDetails_viewPager.adapter = adapterViewPager
            gameDetails_viewPager.currentItem = 0
        }
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int  =
        (itemPosition downTo 0)
            .map { Pair(isHeader(it), it) }
            .firstOrNull { it.first }?.second ?: RecyclerView.NO_POSITION
    override fun getHeaderLayout(headerPosition: Int): Int {
        return R.layout.item_game_detail_tab_bar_section
    }

    override fun bindHeaderData(header: View, headerPosition: Int) {

        if (headerPosition == RecyclerView.NO_POSITION) header.layoutParams.height = 0
        else {
            var tabLayout = header.findViewById<TabLayout>(R.id.gameDetails_tabLayout)
////            if (this::tabLayout.isInitialized) {
////                tabLayout = this.tabLayout.listen
////            }
////            addOnChangeTabLisener(header.findViewById(R.id.gameDetails_tabLayout))
//            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//                override fun onTabReselected(tab: TabLayout.Tab?) {
//                    print(tab)
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab?) {
//                    onTabUnselected(tabLayout.context ,tab?.text.toString())
//                }
//
//                override fun onTabSelected(tab: TabLayout.Tab?) {
//                    onTabSelected(tabLayout.context, tab?.text.toString())
//                }
//
//            })
        }
    }

    override fun isHeader(itemPosition: Int): Boolean {
        return itemPosition == GameDetailsData.TYPE_TAB_BAR_SECTION
    }
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addItemDecoration(HeaderItemDecoration(recyclerView,this))
    }

//    override fun addOnChangeTabLisener(tabLayout: TabLayout) {
////        if (!this::tabLayout.isInitialized)
////            this.tabLayout = tabLayout
//
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                print(tab)
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                print(tab)
//            }
//
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                print(tab)
//            }
//
//        })
//    }

    inner class TournamentViewHolder(private val binding: SectionTournamentGameDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        internal val tournament_recyclerView = binding.root.findViewById<RecyclerView>(R.id.tournament_recyclerView)
        val tournamentAdapter by lazy {
            TournamentSectionAdapter()
        }
        init {
            val layoutManager = LinearLayoutManager(tournament_recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            tournament_recyclerView.layoutManager = layoutManager
            tournament_recyclerView.adapter = tournamentAdapter

        }
        fun bind(tournamentSection: TournamentSection) {
            tournamentAdapter.tournamentList = tournamentSection.values
            tournamentAdapter.sectionName = tournamentSection.sectionName
            binding.apply {
                this.tournament = tournamentSection
            }
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("gameDetails")
        fun RecyclerView.bindItems(items: MutableLiveData<ArrayList<GameDetailsData>>) {
            val adapter = adapter as GameDetailAdapter
            items.observeForever {
                adapter.gameDetailsData = it
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onTabUnselected(context: Context, name: String) {
//        when (name) {
//            context.getString(R.string.tournament) -> {
//                gameDetailsData.
//            }
//            context.getString(R.string.comunity) -> {
//
//            }
//            else -> {
//
//            }
//        }
        val size = gameDetailsData.size
        for (index in (gameDetailsData.size - 1) downTo 2) {
            gameDetailsData.removeAt(index)
        }
//        notifyItemRangeRemoved(2,size - 2)
    }

    override fun onTabSelected(context: Context, name: String) {
        when (name) {
            context.getString(R.string.tournament) -> {
                iChangeTabs.fetchTournament()
            }
            context.getString(R.string.comunity) -> {
                iChangeTabs.fetchComunity()
            }
            else -> {
                iChangeTabs.fetchNews()
            }
        }
    }
}
