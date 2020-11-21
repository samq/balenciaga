package com.balenciaga.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.balenciaga.databases.ProductDao
import com.balenciaga.databases.ProductRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {
    private const val PRODUCT_DATABASE = "products"

    @Singleton
    @Provides
    fun provideProductRoomDatabase(@ApplicationContext context: Context) : ProductRoomDatabase {
        Log.d("CacheModule", "provideProductRoomDatabase")
        return Room.databaseBuilder(context, ProductRoomDatabase::class.java, PRODUCT_DATABASE).build()
    }

    @Singleton
    @Provides
    fun provideProductDAO(roomDatabase : ProductRoomDatabase) : ProductDao {
        Log.d("CacheModule", "provideProductDAO")
        return roomDatabase.getProductDAO()
    }
}