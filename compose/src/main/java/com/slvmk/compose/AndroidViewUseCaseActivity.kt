package com.slvmk.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.slvmk.compose.theme.RoundTableExperimentsTheme

class AndroidViewUseCaseActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoundTableExperimentsTheme {
                AndroidViewSample()
            }
        }
    }
}

@Composable
private fun AndroidViewSample() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            GreetingSample(stringResource(R.string.android_view_title))
            AndroidViewInLazyList()
        }
    }
}

@Composable
private fun AndroidViewInLazyList() {
    LazyColumn (modifier = Modifier.padding(10.dp)) {
        items(10) { index ->
            AndroidView(
                modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
                factory = { context ->
                    CustomTextView(context)
                },
                update = { view ->
                    view.text = view.context.getString(R.string.android_view_text)
                }
            )
        }
    }
}

@Composable
private fun GreetingSample(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(20.dp)
    )
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun DefaultPreview() {
    RoundTableExperimentsTheme {
        AndroidViewSample()
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
private fun DarkModePreview() {
    RoundTableExperimentsTheme {
        AndroidViewSample()
    }
}