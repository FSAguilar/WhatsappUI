package com.example.whatsappui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.WaTextSecondary

@Composable
fun PlaceholderTab(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = title,
            style = TextStyle(
                color = WaTextSecondary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}
