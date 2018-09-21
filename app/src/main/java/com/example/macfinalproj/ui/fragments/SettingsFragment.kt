package com.example.macfinalproj.ui.fragments


import android.os.Bundle
import android.preference.PreferenceFragment
import androidx.fragment.app.Fragment
import com.example.macfinalproj.R


class SettingsFrag: PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)

    }
}