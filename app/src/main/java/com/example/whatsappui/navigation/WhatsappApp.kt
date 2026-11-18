package com.example.whatsappui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.whatsappui.chat.ChatScreen
import com.example.whatsappui.info.InfoScreen
import com.example.whatsappui.main.MainScreen

private enum class AppScreen { MAIN, CHAT, INFO }

@Composable
fun WhatsappApp(modifier: Modifier = Modifier) {
    var screen by rememberSaveable { mutableStateOf(AppScreen.MAIN) }
    var contactName by rememberSaveable { mutableStateOf("María González") }
    var mainTab by rememberSaveable { mutableIntStateOf(0) }

    BackHandler(enabled = screen != AppScreen.MAIN) {
        screen = if (screen == AppScreen.INFO) AppScreen.CHAT else AppScreen.MAIN
    }

    when (screen) {
        AppScreen.MAIN -> MainScreen(
            tabSeleccionada = mainTab,
            onChatClick = {
                contactName = it
                screen = AppScreen.CHAT
            },
            modifier = modifier
        )

        AppScreen.CHAT -> ChatScreen(
            nombre = contactName,
            onBack = { screen = AppScreen.MAIN },
            onInfoClick = { screen = AppScreen.INFO },
            onCallClick = {
                mainTab = 3
                screen = AppScreen.MAIN
            }
        )

        AppScreen.INFO -> InfoScreen(
            nombre = contactName,
            onBack = { screen = AppScreen.CHAT },
            onCallClick = {
                mainTab = 3
                screen = AppScreen.MAIN
            },
            modifier = modifier
        )
    }
}
