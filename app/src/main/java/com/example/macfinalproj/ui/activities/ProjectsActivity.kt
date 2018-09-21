package com.example.macfinalproj.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.macfinalproj.R

import kotlinx.android.synthetic.main.activity_projects.*

class ProjectsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        setSupportActionBar(toolbar)

        initializeAddProjectFloatingButton()
    }

    private fun initializeAddProjectFloatingButton() {
        fab.setOnClickListener { view ->

            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            val view: View = layoutInflater.inflate(R.layout.dialog_addproject, null)
            val etProjectName = findViewById<EditText>(R.id.etProjectName)
            val btnAddProject = findViewById<Button>(R.id.btnAdd_dialogAddProject)
            val btnCancelProject = findViewById<Button>(R.id.btnCancel_dialogAddProject)

            alertDialogBuilder.setView(view)
            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()

            btnAddProject.text = "Hello bitch"

            btnAddProject.setOnClickListener {
                val projectName: String = etProjectName.text.toString()
                alertDialog.dismiss()
            }

            btnCancelProject.setOnClickListener {
                alertDialog.dismiss()
            }

        }
    }
}
