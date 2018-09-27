package com.example.macfinalproj.di.modules

import com.example.macfinalproj.data.remote.APIHelper
import dagger.Module
import dagger.Provides

@Module(includes = [RetrofitModule::class])
class APIServiceHelperModule {
    @Provides
    fun provideRemoteService():APIHelper {
        return APIHelper()
    }
}