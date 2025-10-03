package com.example.hybridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngineCache

class MainActivity : ComponentActivity() {

    private val engineId = "my_cached_engine"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(
                onOpenHome = { navigateToFlutter("/") },
                onOpenDetail = { navigateToFlutter("/detail") }
            )
        }
    }

    private fun navigateToFlutter(route: String) {
        // Use cached FlutterEngine
        val engine = FlutterEngineCache.getInstance().get(engineId)

        // Push new route on existing engine
        engine?.navigationChannel?.pushRoute(route)

        // Launch FlutterActivity with cached engine
        val intent = FlutterActivity.withCachedEngine(engineId).build(this)
        startActivity(intent)
    }
}

@Composable
fun MainScreen(onOpenHome: () -> Unit, onOpenDetail: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onOpenHome) { Text("Open Home") }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onOpenDetail) { Text("Open Detail") }
        }
    }
}
