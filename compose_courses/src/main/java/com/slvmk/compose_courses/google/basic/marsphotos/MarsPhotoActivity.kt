package com.slvmk.compose_courses.google.basic.marsphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.slvmk.compose_courses.google.basic.marsphotos.data.AppContainer
import com.slvmk.compose_courses.google.basic.marsphotos.data.DefaultAppContainer
import com.slvmk.compose_courses.google.basic.marsphotos.ui.MarsPhotosApp
import com.slvmk.compose_courses.ui.theme.MyTheme

class MarsPhotoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MarsPhotosApp()
            }
        }
    }
    companion object {
        var container: AppContainer = DefaultAppContainer()
    }
}