package com.example.macfinalproj.data.remote

import com.example.macfinalproj.data.remote.pojo.Invites
import com.example.macfinalproj.data.remote.pojo.Projects
import com.example.macfinalproj.data.remote.pojo.Status
import com.example.macfinalproj.di.components.DaggerRemoteServiceComponent
import com.example.macfinalproj.di.modules.RetrofitModule
import com.example.macfinalproj.utils.Constants
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject


class APIHelper {
    @Inject
    lateinit var rest_api:APIService

    init {
        DaggerRemoteServiceComponent.builder()
                .retrofitModule(RetrofitModule(Constants.WEB.base_url))
                .build()
                .inject(this)
    }

    fun uploadProfPic() {
        runBlocking(context = CommonPool) {
//            rest_api.changeProfPic().await()
        }

    }

    fun save_project() {
    }


    fun getInvites(user_id:Int):Invites {
        return runBlocking(context = CommonPool) {
            rest_api.getInvites(user_id).await()
        }
    }

    fun answerInvite(invite_id:Int, response:Char):Status {
        return runBlocking(context = CommonPool) {
            val body = mutableMapOf<String, Any>()
            body["response"] = response
            body["invite_id"] = invite_id
            return@runBlocking rest_api.answerInvite(body).await()
        }
    }

    fun createProject(project_owner:Int, project_name:String, project_description:String): Status {
        return runBlocking(context = CommonPool) {
            val body = mutableMapOf<String, Any>()
            body["project_owner"] = project_owner
            body["project_name"] = project_name
            body["project_description"] = project_description
            rest_api.createProject(body).await()
        }
    }

    fun getProjects(owner:Int):Projects {
        return runBlocking(context = CommonPool) {
            rest_api.getProjects(owner).await()
        }
    }
}