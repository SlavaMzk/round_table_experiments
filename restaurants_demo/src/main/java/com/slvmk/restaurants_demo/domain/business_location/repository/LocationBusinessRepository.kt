package com.slvmk.restaurants_demo.domain.business_location.repository

import com.slvmk.restaurants_demo.domain.DataResult
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocationsContainer

/**
 * Created by SlavaMk on 2/27/23.
 */
interface LocationBusinessRepository {
    suspend fun getLocationBusinesses(params: Map<String, String>): DataResult<BusinessLocationsContainer>
}
