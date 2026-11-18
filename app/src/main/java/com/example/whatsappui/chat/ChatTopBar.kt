package com.example.whatsappui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.AppTypography
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen

@Composable
fun ChatTopBar(
    nombre: String,
    estado: String,
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onCallClick: () -> Unit = {}
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
            color = Color.White,
            onClick = onBack
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .clickable(onClick = onInfoClick)
                .semantics { contentDescription = "Información de $nombre" },
            verticalAlignment = Alignment.CenterVertically
        ) {
            ChatAvatar(nombre)
            Spacer(Modifier.width(WaDimens.SpaceSm + WaDimens.SpaceXs))
            Column {
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
        }
        ChatIconButton(
            R.drawable.ic_chat_videocam,
            stringResource(R.string.chat_cd_video_call),
            Color.White,
            onClick = onCallClick
        )
        ChatIconButton(
            R.drawable.ic_chat_call,
            stringResource(R.string.chat_cd_call),
            Color.White,
            onClick = onCallClick
        )
        ChatIconButton(
            R.drawable.ic_chat_more,
            stringResource(R.string.chat_cd_menu),
            Color.White
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ChatTopBarPreview() {
    ChatTopBar(nombre = "María González", estado = "en línea")
}
