package com.example.macfinalproj.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.macfinalproj.data.database.dao.ProjectDao
import com.example.macfinalproj.data.database.dao.TaskDao
import com.example.macfinalproj.data.database.dao.UserDao
import com.example.macfinalproj.data.database.entity.ProjectEntity
import com.example.macfinalproj.data.database.entity.TaskEntity

@Database(entities = [ProjectEntity::class, TaskEntity::class], version = ProjectDB.DB_VERSION, exportSchema = false)
abstract class ProjectDB: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
    abstract fun projectDao(): ProjectDao

    companion object {
        val DB_NAME = "project.db"
        const val DB_VERSION = 1
    }
}