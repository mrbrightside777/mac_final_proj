package com.example.macfinalproj.ui.dialogs

import android.app.ActionBar
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.macfinalproj.R
import com.example.macfinalproj.databinding.ActivityProjectsBinding
import com.example.macfinalproj.databinding.DialogAddprojectBinding
import com.example.macfinalproj.ui.activities.ProjectsActivity
import com.example.macfinalproj.viewmodels.MainActivityViewModel


class AddProjectFormDialog: DialogFragment() {
    private lateinit var binding: DialogAddprojectBinding
    private lateinit var view_model:MainActivityViewModel

    override fun onStart() {
        super.onStart()
        dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view_model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_addproject, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCancelDialogAddProject.setOnClickListener {
            dismiss()
        }
        binding.btnAddDialogAddProject.setOnClickListener {
            view_model.createProject(1, binding.projectName.text.toString(), binding.projectDescription.text.toString())
            startActivity(Intent(activity, ProjectsActivity::class.java))
        }
    }
}
