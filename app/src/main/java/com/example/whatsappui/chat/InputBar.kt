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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappui.R

// Barra inferior para escribir: caja blanca con emoji, texto, clip y cámara + micrófono verde.
// Solo es visual: lo que se escribe no se envía a ningún lado.
@Composable
fun InputBar(modifier: Modifier = Modifier) {
    var texto by remember { mutableStateOf("") }
    val estiloTexto = AppTypography.bodyLarge

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceXs + 2.dp, vertical = 6.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .heightIn(min = WaDimens.ButtonHeight)
                .background(WaBubbleIn, RoundedCornerShape(WaDimens.RadiusLarge))
                .padding(horizontal = WaDimens.SpaceMd - WaDimens.SpaceXs),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ChatIcon(
                id = R.drawable.ic_chat_emoji,
                descripcion = stringResource(R.string.chat_cd_emoji),
                color = WaTextSecondary
            )
            Spacer(modifier = Modifier.width(WaDimens.SpaceSm))
            BasicTextField(
                value = texto,
                onValueChange = { texto = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = WaDimens.SpaceSm + WaDimens.SpaceXs),
                textStyle = estiloTexto.copy(color = WaTextPrimary),
                maxLines = 5,
                cursorBrush = SolidColor(WaGreen),
                decorationBox = { campo ->
                    Box {
                        if (texto.isEmpty()) {
                            BasicText(
                                text = stringResource(R.string.chat_input_hint),
                                style = estiloTexto.copy(color = WaTextSecondary)
                            )
                        }
                        campo()
                    }
                }
            )
            Spacer(modifier = Modifier.width(WaDimens.SpaceSm))
            ChatIcon(
                id = R.drawable.ic_chat_attach,
                descripcion = stringResource(R.string.chat_cd_attach),
                color = WaTextSecondary,
                modifier = Modifier.rotate(-45f)
            )
            Spacer(modifier = Modifier.width(WaDimens.SpaceMd))
            ChatIcon(
                id = R.drawable.ic_chat_camera,
                descripcion = stringResource(R.string.chat_cd_camera),
                color = WaTextSecondary
            )
        }
        Spacer(modifier = Modifier.width(WaDimens.SpaceXs + 2.dp))
        Box(
            modifier = Modifier
                .size(WaDimens.ButtonHeight)
                .clip(CircleShape)
                .background(WaGreen),
            contentAlignment = Alignment.Center
        ) {
            ChatIcon(
                id = R.drawable.ic_chat_mic,
                descripcion = stringResource(R.string.chat_cd_mic),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFEFEAE2, widthDp = 360)
@Composable
private fun InputBarPreview() {
    InputBar()
}
