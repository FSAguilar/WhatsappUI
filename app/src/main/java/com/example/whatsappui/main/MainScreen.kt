package com.example.whatsappui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.WhatsappUITheme
import com.example.whatsappui.ui.theme.WaGreen

@Composable
fun MainScreen(tabSeleccionada: Int = 0, modifier: Modifier = Modifier) {
    var currentTab by remember { mutableStateOf(tabSeleccionada) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBarMain()

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                when (currentTab) {
                    0 -> ChatsTab()
                    1 -> PlaceholderTab(title = "Novedades")
                    2 -> PlaceholderTab(title = "Comunidades")
                    3 -> PlaceholderTab(title = "Llamadas")
                }
            }

            BottomTabs(
                selectedTabIndex = currentTab,
                onTabSelected = { currentTab = it }
            )
        }

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
                    painter = painterResource(id = R.drawable.ic_main_new_chat),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Chats Tab")
@Composable
fun MainScreenChatsPreview() {
    WhatsappUITheme {
        MainScreen(tabSeleccionada = 0)
    }
}

@Preview(showBackground = true, name = "Placeholder Tab")
@Composable
fun MainScreenPlaceholderPreview() {
    WhatsappUITheme {
        MainScreen(tabSeleccionada = 3)
    }
}
