package com.example.macfinalproj.di.components

import com.example.macfinalproj.data.remote.RemoteServiceHelper
import com.example.macfinalproj.di.modules.RestEndpointsModule
import dagger.Component

@Component(modules = [RestEndpointsModule::class])
interface RemoteServiceComponent {
    fun inject(remoteServiceHelper: RemoteServiceHelper)
}