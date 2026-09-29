package com.example.meiwen_rapidrecall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.meiwen_rapidrecall.ui.theme.MeiwenRapidRecallTheme

/**
 * Android entry point for RapidRecall.
 *
 * Design rationale: the activity only configures Compose. Game rules and session
 * data are kept outside the Android lifecycle class so they can be tested and
 * changed independently. Outstanding issues: none currently known.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]
        setContent {
            MeiwenRapidRecallTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RapidRecallApp(gameViewModel)
                }
            }
        }
    }
}
