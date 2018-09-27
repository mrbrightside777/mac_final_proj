package com.example.macfinalproj.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TaskEntity(
        @PrimaryKey
        val id:Int)