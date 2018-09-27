package com.example.macfinalproj.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.preference.PreferenceManager
import com.example.macfinalproj.R
import com.example.macfinalproj.databinding.ActivityMainBinding
import com.example.macfinalproj.ui.fragments.InvitesFragment
import com.example.macfinalproj.ui.fragments.ProjectFragment
import com.example.macfinalproj.ui.fragments.SettingsFragment
import com.example.macfinalproj.utils.ContextWrapper
import com.example.macfinalproj.viewmodels.MainActivityViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var view_model:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bottomNav.selectedItemId = R.id.projects
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.projects -> {
                    supportFragmentManager.popBackStack()
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frag_container, ProjectFragment.newInstance(), "project")
                            .commit()
                }
                R.id.invites -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frag_container, InvitesFragment.newInstance(), "invites")
                            .commit()
                }

                else -> {
                    supportFragmentManager.findFragmentByTag("settings")
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frag_container, SettingsFragment.newInstance(), "settings")
                            .addToBackStack("settings")
                            .commit()
                }
            }
            true
        }
        view_model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        supportFragmentManager.beginTransaction().run {
            val frag = supportFragmentManager.findFragmentByTag("settings") ?: ProjectFragment.newInstance()
            replace(R.id.frag_container, frag, frag.tag)
            commit()
        }
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)

    }

    override fun attachBaseContext(newBase: Context?) {

        val locale = PreferenceManager.getDefaultSharedPreferences(newBase)

        val new_locale = when(locale.getString("language", "English")) {
            "English" -> "en"
            "Russian" -> "ru"
            else -> "es"
        }
        super.attachBaseContext(ContextWrapper.wrap(newBase!!, Locale(new_locale)))
    }

    override fun onBackPressed() {

    }
}
