package com.example.macfinalproj.data.remote

import com.example.macfinalproj.data.models.pojo.ProfPic
import com.example.macfinalproj.data.models.pojo.Project
import com.example.macfinalproj.data.models.pojo.UserInfo
import com.example.macfinalproj.data.remote.pojo.Invites
import com.example.macfinalproj.data.remote.pojo.Projects
import com.example.macfinalproj.data.remote.pojo.Status
import com.example.macfinalproj.utils.Constants
import kotlinx.coroutines.experimental.Deferred
import okhttp3.MultipartBody
import retrofit2.http.*

interface APIService {
    @FormUrlEncoded
    @POST("create_user/")
    fun createUser(@Field("username")
                   username: String,
                   @Field("github_id")
                   github_id:String?=null,
                   @Field("google_id")
                   google_id:String?=null,
                   @Field("profile")
                   profile:String?=null,
                   @Query("key")
                   key: String=Constants.WEB.key):Deferred<UserInfo>

    @GET("get_user/")
    fun userInfo(@Query("username")
                  username: String,
                  @Query("key")
                  key: String=Constants.WEB.key): Deferred<UserInfo>


    @GET("project/get_projects/")
    fun getProjects(@Query("owner")
                    owner: Int,
                    @Query("key") key: String=Constants.WEB.key): Deferred<Projects>

    @Multipart
    @POST("change_prof_pic/")
    fun changeProfPic(@Part file: MultipartBody.Part): Deferred<ProfPic>


    @Headers("Content-Type: application/json")
    @POST("project/create_project/")
    fun createProject(@Body body:MutableMap<String, Any>,  @Query("key") key: String=Constants.WEB.key): Deferred<Status>


    @POST("project/invite_user/")
    fun invite_user(invitor:Int, invitee:Int, project_id:Int):Deferred<Status>

    @GET("user/get_invites/")
    fun getInvites(@Query("user") user_id:Int, @Query("key") key: String=Constants.WEB.key):Deferred<Invites>

    @Headers("Content-Type: application/json")
    @POST("user/answer_invite/")
    fun answerInvite(@Body answer:MutableMap<String, Any>): Deferred<Status>

}