package com.slvmk.restaurants_demo.ui.business_location.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slvmk.databinding.LocationBusinessesItemBinding
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocation

/**
 * Created by SlavaMk on 2/15/22.
 */
class LocationViewHolder(
    private val binding: LocationBusinessesItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: BusinessLocation) {
        binding.apply {
            Glide.with(itemView).load(data.thumbnailUrl).into(imageView)
            titleTextview.text = data.name
            ratingTextview.text = data.rating.toString()
        }
    }
}