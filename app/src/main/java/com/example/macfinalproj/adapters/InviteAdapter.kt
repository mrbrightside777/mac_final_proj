package com.example.macfinalproj.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.macfinalproj.R
import com.example.macfinalproj.data.remote.pojo.ProjectInvites
import com.example.macfinalproj.data.remote.pojo.Status
import com.example.macfinalproj.databinding.InvitesRecyclerItemBinding
import com.example.macfinalproj.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.invites_recycler.view.*

class InviteAdapter(val invites:List<ProjectInvites>, val answer_callback:(Int, Char)-> Status): RecyclerView.Adapter<InviteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:InvitesRecyclerItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.invites_recycler_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = invites.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current_item = invites[position]
        holder.binding.projectTitle.text = current_item.project_name
        holder.binding.projectOwner.text = current_item.invitor
        holder.binding.projectDescription.text = current_item.project_description
        holder.binding.acceptInvite.setOnClickListener {
            answer_callback(current_item.project_id, 'a')
        }
        holder.binding.dismissInvite.setOnClickListener {
            answer_callback(current_item.project_id, 'd')
        }

    }

    inner class ViewHolder(val binding:InvitesRecyclerItemBinding): RecyclerView.ViewHolder(binding.root)
}