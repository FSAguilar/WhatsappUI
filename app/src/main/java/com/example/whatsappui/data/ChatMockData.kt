package com.example.whatsappui.data

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

// Elementos que aparecen en la lista de la conversación.
sealed interface ChatItem {
    data class Separador(val texto: String) : ChatItem

    data class Mensaje(
        val texto: String,
        val hora: String,
        val enviado: Boolean,
        val leido: Boolean = false
    ) : ChatItem
}

// Datos de ejemplo fijos para la sección de Chat (Alvin).
object ChatMockData {

    const val contactoNombre = "María González"
    const val contactoUltimaVez = "10:15"

    val mensajes: List<ChatItem> = listOf(
        ChatItem.Separador("Ayer"),
        ChatItem.Mensaje("¡Hola! ¿Cómo estás?", "21:40", enviado = false),
        ChatItem.Mensaje("¡Hola María! Todo bien, ¿y tú?", "21:42", enviado = true, leido = true),
        ChatItem.Mensaje("Bien también 😊 ¿Mañana vienes a la reunión del proyecto?", "21:43", enviado = false),
        ChatItem.Mensaje("Sí, ahí estaré", "21:45", enviado = true, leido = true),

        ChatItem.Separador("Hoy"),
        ChatItem.Mensaje("Buenos días ☀️", "09:58", enviado = false),
        ChatItem.Mensaje("Te paso el resumen de lo que hablamos ayer", "09:58", enviado = false),
        ChatItem.Mensaje(
            "1. Diego arma la pantalla principal con la lista de chats.\n" +
                "2. Ignacio hace la sección de llamadas.\n" +
                "3. Fidel se encarga de la información del contacto y del grupo.\n" +
                "4. Tú haces la pantalla del chat con las burbujas y la barra para escribir.",
            "10:01",
            enviado = false
        ),
        ChatItem.Mensaje("Perfecto, ya empecé con las burbujas", "10:05", enviado = true, leido = true),
        ChatItem.Mensaje(
            "Las enviadas van a la derecha en verde y las recibidas a la izquierda en blanco",
            "10:05",
            enviado = true,
            leido = true
        ),
        ChatItem.Mensaje("Genial 👌", "10:07", enviado = false),
        ChatItem.Mensaje("¿A qué hora nos juntamos?", "10:08", enviado = false),
        ChatItem.Mensaje("¿Te parece a las 4?", "10:12", enviado = true, leido = true),
        ChatItem.Mensaje("Dale, a las 4 entonces", "10:14", enviado = false),
        ChatItem.Mensaje("Nos vemos 👋", "10:15", enviado = true, leido = false)
    )
}
