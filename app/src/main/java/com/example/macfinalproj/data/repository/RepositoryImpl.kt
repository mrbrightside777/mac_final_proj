package com.example.macfinalproj.data.repository

import com.example.macfinalproj.data.remote.APIHelper
import com.example.macfinalproj.data.remote.pojo.Invites
import com.example.macfinalproj.data.remote.pojo.Projects
import com.example.macfinalproj.data.remote.pojo.Status
import com.example.macfinalproj.di.components.DaggerRemoteServiceHelperComponent
import com.example.macfinalproj.di.modules.RetrofitModule
import com.example.macfinalproj.utils.Constants
import javax.inject.Inject

class RepositoryImpl:Repository {


    @Inject
    lateinit var remoteServiceHelper: APIHelper



    init {
        DaggerRemoteServiceHelperComponent.builder()
                .retrofitModule(RetrofitModule(Constants.WEB.base_url))
                .build()
                .inject(this)
    }


    override fun saveProject(project_name: String, project_description: String) {
    }

    override fun saveTask() {
    }

    override fun getInvites(user_id: Int):Invites {
        return remoteServiceHelper.getInvites(user_id)
    }

    override fun answerInvite(invite_id: Int, response: Char):Status {
        return remoteServiceHelper.answerInvite(invite_id, response)
    }

    override fun createProject(project_owner: Int, project_name: String, project_description: String): Status {
        return remoteServiceHelper.createProject(project_owner, project_name, project_description)
    }

    override fun getProjects(owner: Int):Projects {
        return remoteServiceHelper.getProjects(owner)
    }
}