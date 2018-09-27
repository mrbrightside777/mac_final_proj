package com.example.macfinalproj.di.components

import com.example.macfinalproj.data.repository.RepositoryImpl
import com.example.macfinalproj.di.modules.APIServiceHelperModule
import com.example.macfinalproj.di.modules.RepositoryModule
import com.example.macfinalproj.viewmodels.MainActivityViewModel
import dagger.Component

@Component(modules = [RepositoryModule::class])
interface  RepositoryComponent {
    fun inject(viewModel: MainActivityViewModel)
}