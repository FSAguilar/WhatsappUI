package com.example.whatsappui.calls.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.CallMissed
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.calls.components.ContactAvatar
import com.example.whatsappui.calls.model.CallSampleData
import com.example.whatsappui.calls.model.RecentCall
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaRed
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallInfoScreen(
    call: RecentCall = CallSampleData.sampleRecentCalls[1],
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Info. de la llamada",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = WaTextPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = WaTextPrimary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Más opciones",
                            tint = WaTextPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WaDimens.ScreenPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

            // Avatar grande del contacto
            ContactAvatar(
                name = call.contactName,
                avatarColor = call.avatarColor,
                size = WaDimens.AvatarLarge
            )

            Spacer(modifier = Modifier.height(WaDimens.SpaceMd))

            // Nombre y número de teléfono
            Text(
                text = call.contactName,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = WaTextPrimary
            )
            Spacer(modifier = Modifier.height(WaDimens.SpaceXs))
            Text(
                text = call.phoneNumber,
                fontSize = 15.sp,
                color = WaTextSecondary
            )

            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

            // Fila de botones de acción rápida
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CallInfoActionButton(
                    icon = Icons.Default.Chat,
                    label = "Mensaje",
                    onClick = { }
                )
                CallInfoActionButton(
                    icon = Icons.Default.Phone,
                    label = "Llamada",
                    onClick = { }
                )
                CallInfoActionButton(
                    icon = Icons.Default.Videocam,
                    label = "Video",
                    onClick = { }
                )
                CallInfoActionButton(
                    icon = Icons.Default.Info,
                    label = "Información",
                    onClick = { }
                )
            }

            Spacer(modifier = Modifier.height(WaDimens.SpaceXl))
            HorizontalDivider(color = Color(0xFFE9EDEF))
            Spacer(modifier = Modifier.height(WaDimens.SpaceMd))

            // Detalle de historial de la llamada
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "14 de noviembre",
                    fontSize = 14.sp,
                    color = WaTextSecondary,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(WaDimens.SpaceMd))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.CallMissed,
                        contentDescription = "Llamada perdida",
                        tint = WaRed,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(WaDimens.SpaceMd))
                    Column {
                        Text(
                            text = "Llamada perdida",
                            fontSize = 16.sp,
                            color = WaRed,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "6:09 p. m.",
                            fontSize = 14.sp,
                            color = WaTextSecondary
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CallInfoActionButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .padding(WaDimens.SpaceSm)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0F2F5)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = WaTextPrimary,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(WaDimens.SpaceXs))
        Text(
            text = label,
            fontSize = 12.sp,
            color = WaTextPrimary,
            fontWeight = FontWeight.Medium
        )
    }
}
