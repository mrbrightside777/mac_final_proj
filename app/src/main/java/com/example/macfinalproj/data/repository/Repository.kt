package com.example.macfinalproj.data.repository


import com.example.macfinalproj.data.remote.pojo.Invites
import com.example.macfinalproj.data.remote.pojo.Projects
import com.example.macfinalproj.data.remote.pojo.Status

interface Repository {


    fun saveProject(project_name: String, project_description:String)
    fun saveTask()
    fun getInvites(user_id:Int): Invites
    fun answerInvite(invite_id:Int, response:Char): Status
    fun createProject(project_owner:Int, project_name: String, project_description: String):Status
    fun getProjects(user_id: Int):Projects
}