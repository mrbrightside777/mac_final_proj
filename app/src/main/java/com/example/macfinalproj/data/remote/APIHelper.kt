package com.example.macfinalproj.data.remote

import com.example.macfinalproj.di.components.DaggerRemoteServiceComponent
import com.example.macfinalproj.di.modules.RetrofitModule
import com.example.macfinalproj.utils.Constants
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject


class RemoteServiceHelper {
    @Inject
    lateinit var rest_api:RemoteService

    init {
        DaggerRemoteServiceComponent.builder()
                .retrofitModule(RetrofitModule(Constants.WEB.base_url))
                .build()
                .inject(this)
    }

    fun uploadProfPic() {
        launch(context = CommonPool) {
//            rest_api.changeProfPic().await()
        }

    }

}