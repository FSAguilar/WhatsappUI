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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappui.R

// Barra superior de la conversación: atrás, avatar, nombre/estado y acciones.
@Composable
fun ChatTopBar(
    nombre: String,
    estado: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(WaGreen)
            .statusBarsPadding()
            .height(60.dp)
            .padding(end = WaDimens.SpaceXs),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ChatIconButton(
            id = R.drawable.ic_chat_back,
            descripcion = stringResource(R.string.chat_cd_back),
            color = Color.White
        )
        ChatAvatar(nombre = nombre)
        Spacer(modifier = Modifier.width(WaDimens.SpaceSm + WaDimens.SpaceXs))
        Column(modifier = Modifier.weight(1f)) {
            BasicText(
                text = nombre,
                style = AppTypography.titleMedium.copy(color = Color.White),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            BasicText(
                text = estado,
                style = AppTypography.bodySmall.copy(color = Color.White.copy(alpha = 0.8f)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        ChatIconButton(
            id = R.drawable.ic_chat_videocam,
            descripcion = stringResource(R.string.chat_cd_video_call),
            color = Color.White
        )
        ChatIconButton(
            id = R.drawable.ic_chat_call,
            descripcion = stringResource(R.string.chat_cd_call),
            color = Color.White
        )
        ChatIconButton(
            id = R.drawable.ic_chat_more,
            descripcion = stringResource(R.string.chat_cd_menu),
            color = Color.White
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ChatTopBarEnLineaPreview() {
    ChatTopBar(nombre = "María González", estado = stringResource(R.string.chat_status_online))
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ChatTopBarUltimaVezPreview() {
    ChatTopBar(
        nombre = "María González",
        estado = stringResource(R.string.chat_status_last_seen, "10:15")
    )
}
