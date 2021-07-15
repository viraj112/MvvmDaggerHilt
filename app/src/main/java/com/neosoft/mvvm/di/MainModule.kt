package com.neosoft.mvvm.di

import com.neosoft.mvvm.network.PostApi
import com.neosoft.mvvm.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun getPostApi(retrofit: Retrofit):PostApi{
        return retrofit.create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofitInstance(retrofitInstance: RetrofitInstance):RetrofitInstance{
    return retrofitInstance
    }

}