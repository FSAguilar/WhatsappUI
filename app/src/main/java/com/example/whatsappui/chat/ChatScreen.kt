package com.example.whatsappui.chat

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.whatsappui.ui.theme.AppShapes
import com.example.whatsappui.ui.theme.AppTypography
import com.example.whatsappui.ui.theme.WaBubbleIn
import com.example.whatsappui.ui.theme.WaBubbleOut
import com.example.whatsappui.ui.theme.WaChatBackground
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaGreenLight
import com.example.whatsappui.ui.theme.WaRed
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary
import com.example.whatsappui.ui.theme.WaTextSizes
import com.example.whatsappui.ui.theme.WaTickBlue

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappui.R
import com.example.whatsappui.data.ChatItem
import com.example.whatsappui.data.ChatMockData

// Pantalla de conversación individual.
// No recibe nada obligatorio: por defecto toma los datos de ChatMockData.
@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    nombre: String = ChatMockData.contactoNombre,
    estado: String = stringResource(R.string.chat_status_online),
    elementos: List<ChatItem> = ChatMockData.mensajes
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WaChatBackground)
    ) {
        ChatTopBar(nombre = nombre, estado = estado)

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = WaDimens.SpaceSm)
        ) {
            item { EncryptionNotice() }
            items(elementos) { elemento ->
                when (elemento) {
                    is ChatItem.Separador -> DateSeparator(texto = elemento.texto)
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

@Preview(showBackground = true, widthDp = 360, heightDp = 780)
@Composable
private fun ChatScreenUltimaVezPreview() {
    ChatScreen(
        estado = stringResource(R.string.chat_status_last_seen, ChatMockData.contactoUltimaVez)
    )
}
