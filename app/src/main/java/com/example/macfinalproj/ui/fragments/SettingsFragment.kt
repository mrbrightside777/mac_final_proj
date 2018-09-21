package com.example.macfinalproj.ui.fragments


import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import androidx.core.content.SharedPreferencesCompat
import androidx.fragment.app.Fragment
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.example.macfinalproj.R


class SettingsFragment: PreferenceFragmentCompat() {

    private lateinit var shared_prefs:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        shared_prefs = preferenceManager.sharedPreferences
        editor = shared_prefs.edit()
        setup_lang()
        setup_theme()
    }

    private fun setup_lang() {

        val lang_pref = findPreference("language") as ListPreference
        lang_pref.setDefaultValue(shared_prefs.getString("language", "English"))

        lang_pref.setOnPreferenceChangeListener {
            preference, newValue ->
            editor.putString(preference.key, newValue.toString())
            editor.apply()
            activity?.recreate()
            true
        }
    }

    private fun setup_theme() {
        val theme_pref = findPreference("theme") as ListPreference
        theme_pref.setDefaultValue(shared_prefs.getString("theme", "Light"))

        theme_pref.setOnPreferenceChangeListener {
            preference, newValue ->
            editor.putString(preference.key, newValue.toString())
            editor.apply()
            activity?.recreate()
            true
        }

    }

    companion object {
        fun newInstance():Fragment {
            val frag = SettingsFragment()
            return frag
        }
    }


}