package com.example.macfinalproj.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.macfinalproj.R
import com.example.macfinalproj.databinding.ActivityMainBinding
import com.example.macfinalproj.ui.fragments.ProjectFragment
import com.example.macfinalproj.ui.fragments.SettingsFragment
import com.example.macfinalproj.utils.ContextWrapper
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bottomNav.selectedItemId = R.id.projects
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.projects -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frag_container, ProjectFragment.newInstance()).commit()
                }
                else -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frag_container, SettingsFragment.newInstance()).commit()
                }
            }
            true
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
}
