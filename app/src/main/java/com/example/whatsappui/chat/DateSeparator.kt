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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// Etiqueta de fecha ("Hoy", "Ayer") centrada en un Box blanco redondeado.
@Composable
fun DateSeparator(
    texto: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = WaDimens.SpaceSm),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = texto,
            style = AppTypography.bodySmall.copy(
                color = WaTextSecondary,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .background(WaBubbleIn, RoundedCornerShape(WaDimens.RadiusSmall))
                .padding(horizontal = WaDimens.SpaceMd - WaDimens.SpaceXs, vertical = 6.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFEFEAE2, widthDp = 360)
@Composable
private fun DateSeparatorPreview() {
    DateSeparator(texto = "Hoy")
}
