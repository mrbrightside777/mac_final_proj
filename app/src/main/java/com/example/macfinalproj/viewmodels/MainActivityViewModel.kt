package com.example.macfinalproj.viewmodels

import androidx.lifecycle.ViewModel
import com.example.macfinalproj.data.remote.pojo.Invites
import com.example.macfinalproj.data.remote.pojo.Projects
import com.example.macfinalproj.data.remote.pojo.Status
import com.example.macfinalproj.data.repository.Repository
import com.example.macfinalproj.data.repository.RepositoryImpl
import com.example.macfinalproj.di.components.DaggerRepositoryComponent
import com.example.macfinalproj.di.modules.RetrofitModule
import com.example.macfinalproj.utils.Constants
import javax.inject.Inject

class MainActivityViewModel: ViewModel() {
    @Inject
    lateinit var repo:Repository


    init {
        DaggerRepositoryComponent.builder()
                .build().inject(this)
    }

    fun createTask(project_name: String, project_description: String) {

    }

    fun saveProject(project_name:String, project_description:String, user:String) {

    }

    fun createInvite(invitor:Int, Invitee:Int) {

    }

    fun getInvites(user_id:Int):Invites {
        return repo.getInvites(user_id)
    }

    fun answerInvite(invite_id:Int, response:Char): Status {
        return repo.answerInvite(invite_id, response)
    }


    fun createProject(project_owner:Int, project_name: String, project_description:String):Status {
        return repo.createProject(project_owner, project_name, project_description)
    }

    fun getProjects(owner:Int):Projects {
        return repo.getProjects(owner)
    }


}