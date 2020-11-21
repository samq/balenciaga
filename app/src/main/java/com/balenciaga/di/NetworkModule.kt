package com.balenciaga.di

import android.util.Log
import com.balenciaga.network.ProductAPIService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    // Base URL for API
    private const val BASE_URL = "https://samq.github.io/data/"

    @Singleton
    @Provides
    fun provideMoshi() : Moshi {
        Log.d("NetworkModule", "provideMoshi")
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi) : Retrofit.Builder {
        Log.d("NetworkModule", "provideRetrofit")
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun provideProductAPIService(retrofit: Retrofit.Builder): ProductAPIService {
        Log.d("NetworkModule", "provideProductAPIService")
        return retrofit.build().create(ProductAPIService::class.java)
    }
}