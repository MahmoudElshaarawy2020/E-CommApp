package com.example.e_commapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivityResultRegistryOwner
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.e_commapp.presentation.login.LoginScreen
import com.example.e_commapp.navigation.AppNavigation
import com.example.e_commapp.presentation.home.HomeScreen
import com.example.e_commapp.presentation.register.RegisterScreen
import com.example.e_commapp.ui.theme.ECommAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommAppTheme {
                    HomeScreen()
                }
            }
        }
    }
