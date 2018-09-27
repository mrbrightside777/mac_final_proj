package com.example.macfinalproj.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.macfinalproj.R
import com.example.macfinalproj.adapters.ProjectsAdapter
import com.example.macfinalproj.data.models.pojo.Project
import com.example.macfinalproj.databinding.ActivityProjectsBinding
import com.example.macfinalproj.databinding.ProjectsFragBinding
import com.example.macfinalproj.ui.dialogs.AddProjectFormDialog
import com.example.macfinalproj.viewmodels.MainActivityViewModel

class ProjectFragment: Fragment() {

    private lateinit var binding:ProjectsFragBinding
    private lateinit var view_model:MainActivityViewModel
    private var projects_list:MutableList<Project> = mutableListOf()


    companion object {

        fun newInstance():Fragment {
            val frag = ProjectFragment()
            return frag
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view_model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.projects_frag, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.fab.setOnClickListener {
            AddProjectFormDialog().show(fragmentManager!!.beginTransaction(), "add_proj")
        }
        binding.cont.projectsList.adapter = ProjectsAdapter(projects_list)
        binding.cont.projectsList.layoutManager = LinearLayoutManager(activity)
        projects_list.addAll(view_model.getProjects(1).data)
        binding.cont.projectsList.adapter?.notifyDataSetChanged()

    }


}