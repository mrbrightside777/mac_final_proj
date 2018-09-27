package com.example.macfinalproj.di.components

import com.example.macfinalproj.data.database.db.ProjectDB
import com.example.macfinalproj.di.modules.DatabaseModule
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    fun getDB(): ProjectDB
}