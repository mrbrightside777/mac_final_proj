package com.example.macfinalproj.di.modules

import android.content.Context
import androidx.room.Room
import com.example.macfinalproj.data.database.db.ProjectDB
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(val context: Context) {
    @Provides
    fun provideDB() = Room.databaseBuilder(context, ProjectDB::class.java, ProjectDB.DB_NAME).build()
}