package com.slvmk.roundtableexperiments

import androidx.activity.ComponentActivity
import com.example.jack_experiment.birthday.BirthdayActivity
import com.slvmk.compose.ComposeViewUseCaseActivity
import com.slvmk.compose.HelloComposeWorldActivity
import com.slvmk.compose_courses.google.basic.cupcake.ui.CupcakeActivity
import com.slvmk.compose_courses.google.basic.dogs.DogsListActivity
import com.slvmk.compose_courses.google.basic.marsphotos.MarsPhotoActivity
import com.slvmk.compose_courses.google.medium.OnboardingScreenActivity

object UseCasesContainer {

    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    init {
        //TODO: add experimental features here to the list
        addItem(PlaceholderItem("Use case: show Hello Compose World", HelloComposeWorldActivity::class.java))
        addItem(PlaceholderItem("Use case: show list of images (dogs)", DogsListActivity::class.java))
        addItem(PlaceholderItem("Use case: show birthday card", BirthdayActivity::class.java))
        addItem(PlaceholderItem("Use case: load list of images (Mars)", MarsPhotoActivity::class.java))
        addItem(PlaceholderItem("Use case: simple navigation (Cupcake)", CupcakeActivity::class.java))


        addItem(PlaceholderItem("Use case: switch screens using simple state (Onboarding)", OnboardingScreenActivity::class.java))
        addItem(PlaceholderItem("Use case: ComposeView in View System", ComposeViewUseCaseActivity::class.java))

        /** TODO: add use cases for
            Exception propagation (coroutines)
            Using AndroidView in Jetpack Compose use case
        */
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