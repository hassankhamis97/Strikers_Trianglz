package com.example.strikers_tr.views.home.Fragments.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.model.HomeData
import com.example.strikers_tr.model.StrikersNew
import com.example.strikers_tr.model.TopGame

class SectionalAdapter(
    val homeDataList: Array<HomeData>,
    val isTopGame: Boolean
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        val view: View
        return if (isTopGame) {
            val view = layoutInflater!!.inflate(R.layout.item_game, parent, false)
            TopGamesViewHolder(view)
        } else {
            val view = layoutInflater!!.inflate(R.layout.item_strikers_new, parent, false)
            StrikersNewsViewHolder(view)
        }
    }

    override fun getItemCount(): Int = homeDataList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TopGamesViewHolder){
            holder.bind(position)
        } else if (holder is StrikersNewsViewHolder) {
            holder.bind(position)
        }
    }

    inner class TopGamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val gameCover_IV = itemView.findViewById<ImageView>(R.id.gameCover_IV)
        internal val gameType_textView = itemView.findViewById<TextView>(R.id.gameType_textView)
        internal val gameName_textView = itemView.findViewById<TextView>(R.id.gameName_textView)
        internal val followersNo_textView = itemView.findViewById<TextView>(R.id.followersNo_textView)
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val topGame = homeDataList[position] as TopGame
                gameCover_IV.setImageResource(topGame.image)
                gameType_textView.text = topGame.gameType.name
                gameName_textView.text = topGame.name
                followersNo_textView.text = "${topGame.followersNo} \n Followers"

        }
    }
    inner class StrikersNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val gameCover_IV = itemView.findViewById<ImageView>(R.id.gameCover_IV)
        internal val title_textView = itemView.findViewById<TextView>(R.id.title_textView)
        internal val date_textView = itemView.findViewById<TextView>(R.id.date_textView)
        fun bind(position: Int) {
            val strikersNew = homeDataList[position] as StrikersNew
            gameCover_IV.setImageResource(strikersNew.image)
            title_textView.text = strikersNew.title
            date_textView.text = strikersNew.date

        }
    }
}