package com.example.hybridapp

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugins.GeneratedPluginRegistrant

class MyApplication : Application() {

    companion object {
        const val ENGINE_ID = "my_cached_engine"
    }

    override fun onCreate() {
        super.onCreate()
        preWarmFlutterEngine() // Preload FlutterEngine at startup
    }

    private fun preWarmFlutterEngine() {
        val flutterEngine = FlutterEngine(this)

        // Set initial route
        flutterEngine.navigationChannel.setInitialRoute("/")

        // Start Dart entrypoint
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        // Register plugins
        GeneratedPluginRegistrant.registerWith(flutterEngine)

        // Cache engine for reuse
        FlutterEngineCache.getInstance().put(ENGINE_ID, flutterEngine)
    }
}
