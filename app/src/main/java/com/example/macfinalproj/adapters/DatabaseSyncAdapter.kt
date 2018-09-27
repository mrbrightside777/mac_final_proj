package com.example.macfinalproj.adapters

import android.accounts.Account
import android.content.AbstractThreadedSyncAdapter
import android.content.ContentProviderClient
import android.content.Context
import android.content.SyncResult
import android.os.Bundle

class DatabaseSyncAdapter(context: Context, boolean: Boolean): AbstractThreadedSyncAdapter(context, boolean) {
    override fun onPerformSync(account: Account?, extras: Bundle?, authority: String?, provider: ContentProviderClient?, syncResult: SyncResult?) {

    }

}