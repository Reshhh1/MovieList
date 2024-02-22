package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.navigation.AppNavigation
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           AppLayout {
                AppNavigation()
           }
        }
    }
}

@Composable
fun AppLayout(content: @Composable () -> Unit) {
    MyApplicationTheme {
        content()
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    AppLayout {
        AppNavigation()
    }
}