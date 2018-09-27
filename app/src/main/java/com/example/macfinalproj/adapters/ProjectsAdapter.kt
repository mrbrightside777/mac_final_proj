package com.example.macfinalproj.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.macfinalproj.R


class ProjectsAdapter : RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, null)
        val viewHolder: ViewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ProjectsAdapter.ViewHolder, position: Int) {

    }


    override fun getItemCount() = 100


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}