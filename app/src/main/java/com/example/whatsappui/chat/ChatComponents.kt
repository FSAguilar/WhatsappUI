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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.whatsappui.R

// Piezas pequeñas que solo usa la sección de Chat.

// Ícono vectorial pintado con el color que se le pase.
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

// Ícono dentro de un área de 48dp, como un botón (sin acción).
@Composable
fun ChatIconButton(
    @DrawableRes id: Int,
    descripcion: String?,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.size(WaDimens.ButtonHeight),
        contentAlignment = Alignment.Center
    ) {
        ChatIcon(id = id, descripcion = descripcion, color = color)
    }
}

// Avatar circular con la inicial del contacto.
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
