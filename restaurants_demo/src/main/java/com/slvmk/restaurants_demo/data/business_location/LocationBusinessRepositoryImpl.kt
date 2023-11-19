package com.slvmk.restaurants_demo.data.business_location

import com.slvmk.restaurants_demo.data.api.location_business.LocationBusinessApi
import com.slvmk.restaurants_demo.domain.DataResult
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocation
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocationsContainer
import com.slvmk.restaurants_demo.domain.business_location.repository.LocationBusinessRepository

/**
 * Created by SlavaMk on 2/27/23.
 */
class LocationBusinessRepositoryImpl(private val api: LocationBusinessApi) :
    LocationBusinessRepository {

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