package com.slvmk.restaurants_demo.ui.business_location.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.slvmk.databinding.LocationBusinessesItemBinding
import com.slvmk.restaurants_demo.domain.business_location.BusinessLocation

/**
 * Created by SlavaMk on 2/14/22.
 */
class LocationBusinessAdapter : ListAdapter<BusinessLocation, LocationViewHolder>(Comparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = LocationBusinessesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
private class Comparator : DiffUtil.ItemCallback<BusinessLocation>() {
    override fun areItemsTheSame(oldItem: BusinessLocation, newItem: BusinessLocation): Boolean {
        return oldItem.thumbnailUrl == newItem.thumbnailUrl
    }

    override fun areContentsTheSame(oldItem: BusinessLocation, newItem: BusinessLocation): Boolean {
        return oldItem == newItem
    }
}