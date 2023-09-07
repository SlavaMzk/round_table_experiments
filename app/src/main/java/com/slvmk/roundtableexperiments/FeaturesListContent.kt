package com.slvmk.roundtableexperiments

import androidx.activity.ComponentActivity

object FeaturesListContent {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    init {
        //TODO: add experimental features here to the list
        //addItem(createPlaceholderItem(FeatureName, FeatureActivityClass::class.java))
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
    }
}

/**
 * A placeholder item representing a piece of content.
 */
data class PlaceholderItem(val content: String, val activityClass: Class<out ComponentActivity>) {
    override fun toString(): String = content
}