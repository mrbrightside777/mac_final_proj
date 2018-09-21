package com.example.macfinalproj.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.macfinalproj.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun evt(view: View){
        val intent: Intent = Intent(this, ProjectsActivity::class.java)
        startActivity(intent)
    }
}
