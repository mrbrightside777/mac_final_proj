package com.example.macfinalproj.di.components

import com.example.macfinalproj.data.repository.RepositoryImpl
import com.example.macfinalproj.di.modules.APIServiceHelperModule
import dagger.Component

@Component(modules = [APIServiceHelperModule::class])
interface RemoteServiceHelperComponent {
    fun inject(repo:RepositoryImpl)
}