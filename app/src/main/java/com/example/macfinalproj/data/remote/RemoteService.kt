package com.example.macfinalproj.data.remote

import com.example.macfinalproj.data.models.ProfPic
import com.example.macfinalproj.data.models.Project
import com.example.macfinalproj.data.models.UserInfo
import com.example.macfinalproj.utils.Constants
import kotlinx.coroutines.experimental.Deferred
import okhttp3.MultipartBody
import retrofit2.http.*

interface RemoteService {
    @FormUrlEncoded
    @POST("create_user")
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


    @GET("get_projects/")
    fun getProjects(@Query("user_id")
                    user_id: Int): Deferred<Project>

    @Multipart
    @POST("change_prof_pic/")
    fun changeProfPic(@Part file: MultipartBody.Part): Deferred<ProfPic>

}