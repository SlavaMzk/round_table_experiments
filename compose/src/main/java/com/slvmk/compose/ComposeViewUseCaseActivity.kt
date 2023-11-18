package com.slvmk.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import com.slvmk.compose.databinding.ComposeViewSampleLayoutBinding
import com.slvmk.compose.theme.RoundTableExperimentsTheme

/**
 * More information:
 * https://developer.android.com/jetpack/compose/migrate/interoperability-apis/compose-in-views
 *
 */
class ComposeViewUseCaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ComposeViewSampleLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.composeView.apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                ComposeQuadrantApp()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun DefaultPreview() {
    RoundTableExperimentsTheme {
        ComposeQuadrantApp()
    }
}
