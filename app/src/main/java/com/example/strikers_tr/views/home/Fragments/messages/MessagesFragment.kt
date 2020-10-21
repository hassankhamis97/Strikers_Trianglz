package com.example.strikers_tr.views.home.fragments.messages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.strikers_tr.R
import com.example.strikers_tr.views.home.fragments.messages.chat.ChatActivity

class MessagesFragment: Fragment() {
    lateinit var root: View
    val viewVavigationDecor by lazy {
        activity?.findViewById<LinearLayout>(R.id.view_messages)
    }
    val openChat_Btn by lazy {
        root.findViewById<Button>(R.id.openChat_Btn)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_messages, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewVavigationDecor?.visibility = View.VISIBLE
        openChat_Btn.setOnClickListener {
            handleOpenChat()
        }
    }

    private fun handleOpenChat() {
        val chatIntent = Intent(requireContext(),ChatActivity::class.java)
        activity?.startActivity(chatIntent)
    }

    override fun onDestroyView() {
        viewVavigationDecor?.visibility = View.INVISIBLE
        super.onDestroyView()
    }
}