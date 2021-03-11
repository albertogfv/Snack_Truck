package com.albertogfv.snack_truck.data.db.entities.di

import android.content.Context
import androidx.room.Room
import com.albertogfv.snack_truck.data.db.entities.OrderDatabase
import com.albertogfv.snack_truck.other.Constants.ORDER_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOrderDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        OrderDatabase::class.java,
        ORDER_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: OrderDatabase) = db.getOrderDao()
}