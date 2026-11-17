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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappui.R

// Amarillo del aviso de cifrado (no está en la paleta compartida).
private val ChatNoticeBackground = Color(0xFFFFEECD)

// Aviso amarillo centrado al inicio del chat.
@Composable
fun EncryptionNotice(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceXl, vertical = WaDimens.SpaceSm),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .background(ChatNoticeBackground, RoundedCornerShape(WaDimens.RadiusSmall))
                .padding(horizontal = WaDimens.SpaceMd - WaDimens.SpaceXs, vertical = WaDimens.SpaceSm)
        ) {
            ChatIcon(
                id = R.drawable.ic_chat_lock,
                descripcion = null,
                color = WaTextSecondary,
                modifier = Modifier.padding(top = 2.dp),
                tamano = 12.dp
            )
            Spacer(modifier = Modifier.width(WaDimens.SpaceXs))
            BasicText(
                text = stringResource(R.string.chat_encryption_notice),
                style = AppTypography.bodySmall.copy(
                    color = WaTextSecondary,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFEFEAE2, widthDp = 360)
@Composable
private fun EncryptionNoticePreview() {
    EncryptionNotice()
}
