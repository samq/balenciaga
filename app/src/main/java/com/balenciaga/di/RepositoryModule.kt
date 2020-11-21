package com.balenciaga.di

import android.util.Log
import com.balenciaga.databases.ProductDao
import com.balenciaga.mappers.CacheMapper
import com.balenciaga.mappers.NetworkMapper
import com.balenciaga.network.ProductAPIService
import com.balenciaga.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        localDataSource: ProductDao,
        remoteDataSource: ProductAPIService,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): ProductRepository {
        Log.d("RepositoryModule", "provideProductRepository")
        return ProductRepository(localDataSource, remoteDataSource, cacheMapper, networkMapper)
    }
}