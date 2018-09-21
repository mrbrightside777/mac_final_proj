package com.example.macfinalproj.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.Activity
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.macfinalproj.R
import com.example.macfinalproj.databinding.ActivityMainBinding
import com.example.macfinalproj.utils.Constants
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    lateinit var firebaseLayoutManager: LinearLayoutManager
    lateinit var firebaseAuth: FirebaseAuth

    val TAG = "MainActivity"
    var userName: String = Constants.Firebase.ANONYMOUS

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initializeFirebaseComponents()
        startFirebaseSignIn()
    }

    fun evt(view: View){
        val intent: Intent = Intent(this, ProjectsActivity::class.java)
        startActivity(intent)

    }

    override fun onResume()
    {
        super.onResume()
    }

    override fun onPause()
    {
        super.onPause()
    }

    fun signOut(view: View)
    {
        AuthUI.getInstance().signOut(this)
                .addOnCompleteListener {
                    onSignedOutCleanup()
                }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constants.Firebase.RC_SIGN_IN
                && resultCode == Activity.RESULT_OK)
        {
            firebaseAuth.currentUser?.displayName?.let { onSignedInInitialize(it) }
            Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show()
        }
        else
        {
            var response = IdpResponse.fromResultIntent(data)
            Toast.makeText(this, response?.providerType, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initializeFirebaseComponents()
    {
        firebaseAuth = FirebaseAuth.getInstance()
    }

    private fun onSignedInInitialize(userName: String)
    {
        this.userName = userName
    }

    private fun onSignedOutCleanup()
    {
        userName = Constants.Firebase.ANONYMOUS
        startFirebaseSignIn()
    }

    private fun startFirebaseSignIn()
    {
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .setAvailableProviders(listOf(
                        AuthUI.IdpConfig.GoogleBuilder().build(),
                        AuthUI.IdpConfig.EmailBuilder().build()))
                .build(), Constants.Firebase.RC_SIGN_IN)
    }


    private fun Any?.isNotNull(): Boolean
    {
        return this != null
    }
}
