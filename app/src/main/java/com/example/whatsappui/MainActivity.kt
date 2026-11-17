package com.example.whatsappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappui.ui.calls.CallsNavigationContainer
import com.example.whatsappui.ui.calls.screens.CallInfoScreen
import com.example.whatsappui.ui.calls.screens.CallsMainScreen
import com.example.whatsappui.ui.calls.screens.DialpadScreen
import com.example.whatsappui.ui.calls.screens.ScheduleCallScreen
import com.example.whatsappui.ui.calls.screens.SelectContactScreen
import com.example.whatsappui.ui.theme.WhatsappUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsappUITheme {
                CallsNavigationContainer()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CallsAppMainPreview() {
    WhatsappUITheme {
        CallsMainScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun CallInfoScreenPreview() {
    WhatsappUITheme {
        CallInfoScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ScheduleCallScreenPreview() {
    WhatsappUITheme {
        ScheduleCallScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DialpadScreenPreview() {
    WhatsappUITheme {
        DialpadScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SelectContactScreenPreview() {
    WhatsappUITheme {
        SelectContactScreen()
    }
}
