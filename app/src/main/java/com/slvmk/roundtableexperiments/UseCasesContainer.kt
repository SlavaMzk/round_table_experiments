package com.slvmk.roundtableexperiments

import androidx.activity.ComponentActivity
import com.slvmk.compose.HelloComposeWorldActivity

object UseCasesContainer {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    init {
        //TODO: add experimental features here to the list
        addItem(PlaceholderItem("Use case: show Hello Compose World", HelloComposeWorldActivity::class.java))
        addItem(PlaceholderItem("Test Use Case2", HelloComposeWorldActivity::class.java))
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