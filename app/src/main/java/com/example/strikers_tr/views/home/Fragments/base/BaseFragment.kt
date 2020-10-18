package com.example.strikers_tr.views.home.Fragments.base

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.strikers_tr.R

class BaseFragment: Fragment() {
    lateinit var root: View
    val currentActivity: AppCompatActivity by lazy { activity as AppCompatActivity }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_base, container, false) as View
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()


    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    private fun setupActionBar() {
        val toolbar = root.findViewById<Toolbar>(R.id.base_toolbar)
        toolbar.title = ""
        currentActivity.setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

    }
}