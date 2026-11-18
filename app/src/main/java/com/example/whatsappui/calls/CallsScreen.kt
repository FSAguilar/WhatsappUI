package com.example.whatsappui.calls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.R
import com.example.whatsappui.data.CallPreview
import com.example.whatsappui.data.MockData
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaRed
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary
import com.example.whatsappui.ui.theme.WhatsappUITheme

@Composable
fun CallsScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            Text(
                text = "Llamadas",
                color = WaTextPrimary,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CallLinkAvatar()
                Spacer(Modifier.width(16.dp))
                Column {
                    Text("Crear enlace de llamada", color = WaTextPrimary, fontSize = 16.sp)
                    Text(
                        "Comparte un enlace para tu llamada de WhatsApp",
                        color = WaTextSecondary,
                        fontSize = 13.sp
                    )
                }
            }
            Text(
                text = "Recientes",
                color = WaTextPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 18.dp, bottom = 6.dp)
            )
        }
        items(MockData.calls) { call ->
            CallRow(call)
        }
    }
}

@Composable
private fun CallRow(call: CallPreview) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(WaGreen.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            BasicText(
                text = call.name.take(1).uppercase(),
                style = TextStyle(
                    color = WaGreen,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(Modifier.width(14.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = if (call.count > 1) "${call.name} (${call.count})" else call.name,
                color = if (call.isMissed) WaRed else WaTextPrimary,
                fontSize = 16.sp
            )
            Text(
                text = (if (call.isIncoming) "↙ " else "↗ ") + call.time,
                color = if (call.isMissed) WaRed else WaTextSecondary,
                fontSize = 13.sp
            )
        }
        Icon(
            painter = painterResource(R.drawable.ic_chat_call),
            contentDescription = "Llamar a ${call.name}",
            tint = WaGreen,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun CallLinkAvatar() {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(WaGreen),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.link_2),
            contentDescription = "Crear enlace de llamada",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CallsScreenPreview() {
    WhatsappUITheme {
        CallsScreen()
    }
}
