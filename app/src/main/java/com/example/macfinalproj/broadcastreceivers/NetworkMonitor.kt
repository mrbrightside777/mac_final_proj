package com.example.macfinalproj.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class NetworkMonitor: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

    }

    private fun is_connected(context: Context?):Boolean {
        val con_manager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val net_info = con_manager.activeNetworkInfo
        return net_info.isConnected
    }

}