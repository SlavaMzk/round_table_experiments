package com.slvmk.restaurants_demo.di

import com.slvmk.restaurants_demo.data.api.ApiKeyInterceptor
import com.slvmk.restaurants_demo.data.api.location_business.LocationBusinessApi
import com.slvmk.restaurants_demo.data.api.location_business.LocationBusinessConstants
import com.slvmk.restaurants_demo.data.business_location.LocationBusinessRepositoryImpl
import com.slvmk.restaurants_demo.domain.business_location.repository.LocationBusinessRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by SlavaMk on 2/27/23.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(locationBusinessesApi: LocationBusinessApi):
            LocationBusinessRepository = LocationBusinessRepositoryImpl(locationBusinessesApi)

    @Provides
    @Singleton
    fun provideLocationSearchApiImpl(retrofit: Retrofit): LocationBusinessApi =
        retrofit.create(LocationBusinessApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(LocationBusinessConstants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(ApiKeyInterceptor(LocationBusinessConstants.API_KEY))
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()
            ).build()
}