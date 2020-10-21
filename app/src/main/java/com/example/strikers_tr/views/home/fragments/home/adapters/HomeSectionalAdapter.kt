package com.example.strikers_tr.views.home.fragments.home.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.ItemStrikersNewBinding
import com.example.strikers_tr.databinding.SectionFriendRequestBinding
import com.example.strikers_tr.databinding.SectionTopGamesBinding
import com.example.strikers_tr.model.*
import com.example.strikers_tr.model.HomeData.Companion.TYPE_FRIEND_REQUEST
import com.example.strikers_tr.model.HomeData.Companion.TYPE_STRIKERS_NEWS
import com.example.strikers_tr.model.HomeData.Companion.TYPE_TOP_GAME
import com.example.strikers_tr.model.HomeData.Companion.TYPE_WELCOME
import com.example.strikers_tr.views.home.fragments.home.protocols.IHomeData
import com.yuyakaido.android.cardstackview.*

class HomeSectionalAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(), IHomeData {
    lateinit var homeDataList: ArrayList<HomeData>
    override fun getItemViewType(position: Int): Int {
        return when {
            homeDataList[position].getType() == TYPE_STRIKERS_NEWS -> {
                TYPE_STRIKERS_NEWS
            }
            homeDataList[position].getType() == TYPE_TOP_GAME -> {
                TYPE_TOP_GAME
            }
            homeDataList[position].getType() == TYPE_FRIEND_REQUEST -> {
                TYPE_FRIEND_REQUEST
            }
            else -> {
                TYPE_WELCOME
            }
        }
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        return when (viewType) {
            TYPE_STRIKERS_NEWS -> {
    //            val view = layoutInflater!!.inflate(R.layout.item_strikers_new, parent, false)
                val binding = DataBindingUtil.inflate<ItemStrikersNewBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_strikers_new, parent, false
                )
                StrikersNewsViewHolder(binding)
            }
            TYPE_TOP_GAME -> {
                val binding = DataBindingUtil.inflate<SectionTopGamesBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.section_top_games, parent, false
                )
                TopGamesViewHolder(binding)

            }
            TYPE_FRIEND_REQUEST -> {
                val binding = DataBindingUtil.inflate<SectionFriendRequestBinding>(
                        LayoutInflater.from(parent.context),
                        R.layout.section_friend_request, parent, false
                )
                FriendRequestViewHolder(binding,this)

            }
            else -> {
                val view = layoutInflater!!.inflate(R.layout.section_welcome_player, parent, false)

                WelcomePlayerViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int = homeDataList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TopGamesViewHolder -> {
                holder.bind(homeDataList[position] as TopGames)
            }
            is StrikersNewsViewHolder -> {
                holder.bind(homeDataList[position] as StrikersNew)
            }
            is WelcomePlayerViewHolder -> {
                holder.bind()
            }
            is FriendRequestViewHolder -> {
                holder.bind(homeDataList[position] as FriendRequests)
            }
        }
    }
    inner class WelcomePlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {

        }
    }
    inner class FriendRequestViewHolder(
        private val binding: SectionFriendRequestBinding,
        val homeSectionalAdapter: IHomeData
    ) : RecyclerView.ViewHolder(binding.root) {
        internal val friendRequest_cardStackView = binding.root.findViewById<CardStackView>(R.id.friendRequest_cardStackView)

        fun bind(friendRequests: FriendRequests) {
//            val cardListener =
            val cardStackLayoutManager = CardStackLayoutManager(friendRequest_cardStackView.context,object : CardStackListener {
                override fun onCardDisappeared(view: View?, position: Int) {
                    Log.d("card","onCardDisappeared position = ${position}")
                    if (position == homeSectionalAdapter.getFriendRequestSize() - 1) {
                        homeSectionalAdapter.removeFriendRequests()
                    }

                }

                override fun onCardDragging(direction: Direction?, ratio: Float) {
                    Log.d("card"," onCardDragging")

                }

                override fun onCardSwiped(direction: Direction?) {
                    Log.d("card","onCardSwiped")

                }

                override fun onCardCanceled() {
                    Log.d("card","onCardCanceled")

                }

                override fun onCardAppeared(view: View?, position: Int) {
                    Log.d("card","onCardAppeared position = ${position}")

                }

                override fun onCardRewound() {

                }

            })
            friendRequest_cardStackView.layoutManager = cardStackLayoutManager
            friendRequest_cardStackView.adapter =
                FriendRequestsAdapter(
                    friendRequests.friendRequestsList
                )
            cardStackLayoutManager.setStackFrom(StackFrom.Bottom)
            cardStackLayoutManager.setVisibleCount(3)
            cardStackLayoutManager.setTranslationInterval(8.0f)
            cardStackLayoutManager.setDirections(Direction.HORIZONTAL)
            cardStackLayoutManager.setCanScrollHorizontal(true)
            cardStackLayoutManager.setCanScrollVertical(false)
            cardStackLayoutManager.setScaleInterval(0.9f)

            binding.apply {
                this.friendRequests = friendRequests
            }
        }
    }
    inner class TopGamesViewHolder(private val binding: SectionTopGamesBinding) : RecyclerView.ViewHolder(binding.root) {
        internal val games_recyclerView = binding.root.findViewById<RecyclerView>(R.id.games_recyclerView)
        val gamesAdapter by lazy {
            TopGamesAdapter()
        }
        init {
            val layoutManager = LinearLayoutManager(games_recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            games_recyclerView.layoutManager = layoutManager
            games_recyclerView.adapter = gamesAdapter

        }
        fun bind(topGames: TopGames) {
            gamesAdapter.topGamesList = topGames.topGamesList
            binding.apply {
                this.topGames = topGames
            }
        }
    }
    inner class StrikersNewsViewHolder(private val binding: ItemStrikersNewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StrikersNew) {
            binding.apply {
                strikerNew = item
                executePendingBindings()
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("homeDataList")
        fun RecyclerView.bindItems(items: MutableLiveData<ArrayList<HomeData>>) {
            val adapter = adapter as HomeSectionalAdapter
            items.observeForever {
                adapter.homeDataList = it
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun removeFriendRequests() {
        val friendRequests = homeDataList.filterIsInstance<FriendRequests>().firstOrNull()
        if (friendRequests != null) {
            val position = homeDataList.indexOf(friendRequests)
            homeDataList.remove(friendRequests)
            notifyItemRemoved(position)
        }

    }

    override fun getFriendRequestSize(): Int {
        val friendRequests = homeDataList.filterIsInstance<FriendRequests>().firstOrNull()
        return if (friendRequests != null) {
             friendRequests.friendRequestsList.size
        } else {
            0
        }
    }
}