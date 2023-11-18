package com.slvmk.restaurants_demo.data.api.location_business

import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by SlavaMk on 2/27/23.
 */
interface LocationBusinessApi {

    @GET(LocationBusinessConstants.BUSINESS_SEARCH)
    suspend fun getLocationBusinesses(@QueryMap params: Map<String, String>): LocationBusinessResponse
}