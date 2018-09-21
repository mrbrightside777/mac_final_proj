package com.example.macfinalproj.data.models

data class Tasks(val taskId:Int,
                 val name:String,
                 val creationDate:String,
                 val requiredBefore:String,
                 val completedOn: String)