package com.example.whatsappui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappui.R
import com.example.whatsappui.calls.CallsNavigationContainer
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WhatsappUITheme

@Composable
fun MainScreen(
    tabSeleccionada: Int = 0,
    onChatClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var currentTab by rememberSaveable(tabSeleccionada) { mutableIntStateOf(tabSeleccionada) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(Modifier.fillMaxSize()) {
            if (currentTab != 3) TopBarMain()

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                when (currentTab) {
                    0 -> ChatsTab(onChatClick)
                    1 -> PlaceholderTab(title = "Novedades")
                    2 -> PlaceholderTab(title = "Comunidades")
                    3 -> CallsNavigationContainer()
                }
            }

            BottomTabs(
                selectedTabIndex = currentTab,
                onTabSelected = { currentTab = it }
            )
        }

        if (currentTab == 0) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp, end = 16.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(WaGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_main_new_chat),
                        contentDescription = "Nuevo chat",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Chats")
@Composable
private fun MainScreenChatsPreview() {
    WhatsappUITheme { MainScreen() }
}

@Preview(showBackground = true, name = "Llamadas")
@Composable
private fun MainScreenCallsPreview() {
    WhatsappUITheme { MainScreen(tabSeleccionada = 3) }
}
