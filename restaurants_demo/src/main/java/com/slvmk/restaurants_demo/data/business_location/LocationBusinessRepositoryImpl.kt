package com.slvmk.restaurants_demo.data.business_location

import com.slvmk.restaurants_demo.data.api.location_business.LocationBusinessApi
import com.slvmk.restaurants_demo.data.api.location_business.LocationBusinessResponse
import com.slvmk.restaurants_demo.domain.DataResult
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocation
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocationsContainer
import com.slvmk.restaurants_demo.domain.business_location.repository.LocationBusinessRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by SlavaMk on 2/27/23.
 */
class LocationBusinessRepositoryImpl(private val api: LocationBusinessApi) :
    LocationBusinessRepository {

    private val refreshIntervalMs: Long = 5000


    val latestNews: Flow<Result<LocationBusinessResponse>> = flow {
        while(true) {
            /*val latestNews = newsApi.fetchLatestNews()
            val response = api.getLocationBusinesses(params)
            Result.Success(response)

            emit(latestNews) // Emits the result of the request to the flow*/
            delay(refreshIntervalMs) // Suspends the coroutine for some time
        }
    }


    override suspend fun getLocationBusinesses(params: Map<String, String>): DataResult<BusinessLocationsContainer> {
        return try {
            val response = api.getLocationBusinesses(params)
            val result = response.businesses.map { BusinessLocation(it.name, it.thumbnailUrl, it.rating) }

            DataResult.Success(BusinessLocationsContainer(result))
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }

}