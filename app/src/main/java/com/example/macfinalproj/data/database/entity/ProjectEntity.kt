package com.example.macfinalproj.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProjectEntity(
        @PrimaryKey
        val project_id:Int
)