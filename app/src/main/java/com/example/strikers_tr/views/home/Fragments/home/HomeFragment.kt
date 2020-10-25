package com.example.strikers_tr.views.home.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strikers_tr.R
import com.example.strikers_tr.databinding.FragmentHomeBinding
import com.example.strikers_tr.views.home.fragments.home.adapters.HomeSectionalAdapter
import org.w3c.dom.Text


class HomeFragment: Fragment() {
    lateinit var root: View
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    val viewVavigationDecor by lazy {
        activity?.findViewById<LinearLayout>(R.id.view_home)
    }
    val homeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false
        )
        binding.apply {
            this.vm = homeViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewVavigationDecor?.visibility = View.VISIBLE
        homeViewModel.fetchHomeData()
        setupAdapter()
    }
    private fun setupAdapter() {
        val recyclerView = root.findViewById<RecyclerView>(R.id.homeAdapter_recyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = HomeSectionalAdapter()
    }

    override fun onDestroyView() {
        viewVavigationDecor?.visibility = View.INVISIBLE
        super.onDestroyView()
    }
}