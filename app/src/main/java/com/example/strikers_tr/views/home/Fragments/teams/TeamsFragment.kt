package com.example.strikers_tr.views.home.fragments.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.strikers_tr.R

class TeamsFragment: Fragment() {
    lateinit var root: View
    val viewVavigationDecor by lazy {
        activity?.findViewById<LinearLayout>(R.id.view_teams)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_teams, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewVavigationDecor?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        viewVavigationDecor?.visibility = View.INVISIBLE
        super.onDestroyView()
    }
}