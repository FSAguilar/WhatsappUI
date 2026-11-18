package com.example.whatsappui.chat

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.AppTypography
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaTextSecondary
import com.example.whatsappui.ui.theme.WaTickBlue

@Composable
fun ChatIcon(
    @DrawableRes id: Int,
    descripcion: String?,
    color: Color,
    modifier: Modifier = Modifier,
    tamano: Dp = WaDimens.IconSize
) {
    Image(
        painter = painterResource(id),
        contentDescription = descripcion,
        colorFilter = ColorFilter.tint(color),
        modifier = modifier.size(tamano)
    )
}

@Composable
fun ChatIconButton(
    @DrawableRes id: Int,
    descripcion: String?,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .size(WaDimens.ButtonHeight)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        ChatIcon(id = id, descripcion = descripcion, color = color)
    }
}

@Composable
fun ChatAvatar(
    nombre: String,
    modifier: Modifier = Modifier,
    tamano: Dp = WaDimens.AvatarSmall
) {
    Box(
        modifier = modifier
            .size(tamano)
            .clip(CircleShape)
            .background(WaTextSecondary),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = nombre.take(1).uppercase(),
            style = AppTypography.titleMedium.copy(color = Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatComponentsPreview() {
    Row {
        ChatAvatar(nombre = "María")
        ChatIconButton(R.drawable.ic_chat_call, null, WaGreen)
        ChatIconButton(R.drawable.ic_chat_double_tick, null, WaTickBlue)
    }
}
