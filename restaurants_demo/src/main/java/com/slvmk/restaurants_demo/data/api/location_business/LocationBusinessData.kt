package com.slvmk.restaurants_demo.data.api.location_business

import com.google.gson.annotations.SerializedName

/**
 * Created by SlavaMk on 2/27/23.
 */
data class LocationBusinessData(
    @SerializedName("name") val name : String,
    @SerializedName("image_url") val thumbnailUrl : String,
    @SerializedName("rating") val rating : Double
)