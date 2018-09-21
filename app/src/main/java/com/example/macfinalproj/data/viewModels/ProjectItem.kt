package com.example.macfinalproj.data.viewModels

data class Project(val projectId:Int,
                   val name:String,
                   val description:String,
                   val teamCount:Int,
                   val pendingCount: Int,
                   val inProgressCount: Int,
                   val completedCount: Int)