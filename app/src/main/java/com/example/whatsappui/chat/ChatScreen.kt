package com.example.whatsappui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappui.R
import com.example.whatsappui.data.ChatItem
import com.example.whatsappui.data.ChatMockData
import com.example.whatsappui.ui.theme.WaChatBackground
import com.example.whatsappui.ui.theme.WaDimens

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    nombre: String = ChatMockData.contactoNombre,
    estado: String = stringResource(R.string.chat_status_online),
    elementos: List<ChatItem> = ChatMockData.mensajes,
    onBack: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onCallClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WaChatBackground)
    ) {
        ChatTopBar(
            nombre = nombre,
            estado = estado,
            onBack = onBack,
            onInfoClick = onInfoClick,
            onCallClick = onCallClick
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = WaDimens.SpaceSm)
        ) {
            item { EncryptionNotice() }
            items(elementos) { elemento ->
                when (elemento) {
                    is ChatItem.Separador -> DateSeparator(elemento.texto)
                    is ChatItem.Mensaje -> MessageBubble(
                        texto = elemento.texto,
                        hora = elemento.hora,
                        enviado = elemento.enviado,
                        leido = elemento.leido
                    )
                }
            }
        }

        InputBar(
            modifier = Modifier
                .navigationBarsPadding()
                .imePadding()
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 780)
@Composable
private fun ChatScreenPreview() {
    ChatScreen()
}
