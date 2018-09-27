package com.example.macfinalproj.di.modules

import com.example.macfinalproj.data.remote.APIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
class RestEndpointsModule {

    @Provides
    fun provideRestEndpoints(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

}