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
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappui.R

// Esquina pequeña del lado del remitente para imitar la "colita".
private val EsquinaColita = 2.dp

// Burbuja de mensaje: cambia de lado, color y ticks según "enviado".
@Composable
fun MessageBubble(
    texto: String,
    hora: String,
    enviado: Boolean,
    leido: Boolean,
    modifier: Modifier = Modifier
) {
    val forma = if (enviado) {
        RoundedCornerShape(
            topStart = WaDimens.RadiusSmall,
            topEnd = EsquinaColita,
            bottomEnd = WaDimens.RadiusSmall,
            bottomStart = WaDimens.RadiusSmall
        )
    } else {
        RoundedCornerShape(
            topStart = EsquinaColita,
            topEnd = WaDimens.RadiusSmall,
            bottomEnd = WaDimens.RadiusSmall,
            bottomStart = WaDimens.RadiusSmall
        )
    }
    val fondo = if (enviado) WaBubbleOut else WaBubbleIn

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceSm, vertical = 2.dp)
    ) {
        // Ancho máximo ~80% de la pantalla.
        val anchoMaximo = maxWidth * 0.8f

        Column(
            modifier = Modifier
                .align(if (enviado) Alignment.CenterEnd else Alignment.CenterStart)
                .widthIn(max = anchoMaximo)
                .background(fondo, forma)
                .padding(
                    start = WaDimens.SpaceSm,
                    end = WaDimens.SpaceSm,
                    top = 6.dp,
                    bottom = WaDimens.SpaceXs
                )
        ) {
            BasicText(
                text = texto,
                style = AppTypography.bodyLarge.copy(color = WaTextPrimary)
            )
            Row(
                modifier = Modifier.align(Alignment.End),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicText(
                    text = hora,
                    style = AppTypography.bodySmall.copy(
                        color = WaTextSecondary,
                        fontSize = 11.sp
                    )
                )
                if (enviado) {
                    Spacer(modifier = Modifier.width(WaDimens.SpaceXs))
                    ChatIcon(
                        id = R.drawable.ic_chat_double_tick,
                        descripcion = stringResource(
                            if (leido) R.string.chat_cd_read else R.string.chat_cd_delivered
                        ),
                        color = if (leido) WaTickBlue else WaTextSecondary,
                        tamano = WaDimens.SpaceMd
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFEFEAE2, widthDp = 360)
@Composable
private fun MessageBubblePreview() {
    Column {
        MessageBubble("¡Hola! ¿Cómo estás?", "10:01", enviado = false, leido = false)
        MessageBubble("Todo bien, ¿y tú?", "10:02", enviado = true, leido = true)
        MessageBubble("Nos vemos 👋", "10:03", enviado = true, leido = false)
        MessageBubble(
            "Este es un mensaje largo para comprobar que la burbuja no pasa del 80% del ancho " +
                "de la pantalla y que el texto se reparte en varias líneas.",
            "10:04",
            enviado = false,
            leido = false
        )
    }
}
