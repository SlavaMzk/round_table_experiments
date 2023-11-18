package com.slvmk.restaurants_demo.data.api.location_business

import com.google.gson.annotations.SerializedName

/**
 * Created by SlavaMk on 2/27/23.
 */
class LocationBusinessResponse (
    @SerializedName("businesses") val businesses : List<LocationBusinessData>
)