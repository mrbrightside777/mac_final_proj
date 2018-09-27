package com.example.macfinalproj.di.modules

import com.example.macfinalproj.data.repository.Repository
import com.example.macfinalproj.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {
    @Provides
    fun providesRepo():Repository = RepositoryImpl()
}