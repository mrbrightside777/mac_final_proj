package com.example.macfinalproj.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.macfinalproj.R
import com.example.macfinalproj.data.models.pojo.Project
import com.example.macfinalproj.databinding.ProjectsAdapterItemsBinding
import com.example.macfinalproj.ui.activities.ProjectsActivity

class ProjectsAdapter(val projects:List<Project>): RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ProjectsAdapterItemsBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                it.context.startActivity(Intent(it.context, ProjectsActivity::class.java))
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ProjectsAdapterItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.projects_adapter_items,
                parent,
                false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = projects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current_item = projects[position]
        holder.binding.projectName.text = current_item.name
        holder.binding.projectDescription.text = current_item.description
    }


}