package com.example.fisherman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fisherman.ui.app.FishermanApp
import com.example.fisherman.ui.theme.DapDriftTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DapDriftTheme {
                FishermanApp()
            }
        }
    }
}