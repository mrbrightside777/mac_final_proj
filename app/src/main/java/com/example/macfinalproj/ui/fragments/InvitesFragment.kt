package com.example.macfinalproj.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.macfinalproj.R
import com.example.macfinalproj.adapters.InviteAdapter
import com.example.macfinalproj.data.remote.pojo.ProjectInvites
import com.example.macfinalproj.databinding.InvitesRecyclerBinding
import com.example.macfinalproj.viewmodels.MainActivityViewModel

class InvitesFragment: Fragment() {
    private lateinit var binding:InvitesRecyclerBinding
    private lateinit var view_model:MainActivityViewModel
    private var invites:MutableList<ProjectInvites> = mutableListOf()


    companion object {
        var instance:InvitesFragment?=null
        fun newInstance():InvitesFragment {
            if (instance == null)
                instance = InvitesFragment()
            return instance!!
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.invites_recycler, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view_model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        invites.addAll(view_model.getInvites(1).data)
        binding.invitesRecycler.adapter = InviteAdapter(invites, view_model::answerInvite)
        if (invites.size == 0) {
            binding.invitesRecycler.visibility = View.GONE
            binding.emptyInvites.visibility = View.VISIBLE
        } else {
            binding.invitesRecycler.visibility = View.VISIBLE
            binding.emptyInvites.visibility = View.GONE
        }
        val swag  = ""

    }
}