package com.example.macfinalproj.di.modules

import com.example.macfinalproj.data.remote.RemoteService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
class RestEndpointsModule {

    @Provides
    fun provideRestEndpoints(retrofit: Retrofit): RemoteService {
        return retrofit.create(RemoteService::class.java)
    }

}