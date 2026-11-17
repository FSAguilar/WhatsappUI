package com.example.whatsappui.ui.calls.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.calls.model.ScheduledEvent
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaGreenLight
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleCallScreen(
    onBackClick: () -> Unit = {},
    onSaveEvent: (ScheduledEvent) -> Unit = {}
) {
    var eventTitle by remember { mutableStateOf("Llamada de Ignacio Cardenas") }
    var description by remember { mutableStateOf("") }
    var isVideoCall by remember { mutableStateOf(true) }
    var requireApproval by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Crea un evento",
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
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onSaveEvent(
                        ScheduledEvent(
                            title = eventTitle,
                            description = description,
                            isVideoCall = isVideoCall,
                            requireApproval = requireApproval
                        )
                    )
                    onBackClick()
                },
                containerColor = WaGreenLight,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Guardar evento"
                )
            }
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = WaDimens.ScreenPadding)
        ) {
            Spacer(modifier = Modifier.height(WaDimens.SpaceSm))

            // Banner superior de ícono de evento
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(WaDimens.RadiusSmall))
                    .background(Color(0xFFF0F2F5)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.EventNote,
                    contentDescription = "Evento",
                    tint = WaTextSecondary,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.height(WaDimens.SpaceMd))

            // Título del evento
            OutlinedTextField(
                value = eventTitle,
                onValueChange = { eventTitle = it },
                label = { Text("Nombre del evento", color = WaTextSecondary) },
                trailingIcon = {
                    if (eventTitle.isNotEmpty()) {
                        IconButton(onClick = { eventTitle = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Borrar",
                                tint = WaTextSecondary
                            )
                        }
                    }
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = WaGreen,
                    unfocusedBorderColor = Color(0xFFE9EDEF)
                )
            )

            Spacer(modifier = Modifier.height(WaDimens.SpaceSm))

            // Descripción opcional
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                placeholder = { Text("Descripción (opcional)", color = WaTextSecondary) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = WaGreen,
                    unfocusedBorderColor = Color(0xFFE9EDEF)
                )
            )

            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))
            HorizontalDivider(color = Color(0xFFF0F2F5))
            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

            // Fecha y Hora Inicio
            ScheduleOptionRow(
                icon = Icons.Default.CalendarToday,
                title = "mar, 17 de nov",
                subtitle = "9:30 a. m.",
                onClick = { }
            )

            Spacer(modifier = Modifier.height(WaDimens.SpaceMd))

            // Fecha y Hora Fin
            ScheduleOptionRow(
                icon = Icons.Default.CalendarToday,
                title = "mar, 17 de nov",
                subtitle = "10:00 a. m.",
                onClick = { }
            )

            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

            // Tipo de llamada (Video / Audio)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WaDimens.RadiusMedium))
                    .clickable { isVideoCall = !isVideoCall }
                    .padding(vertical = WaDimens.SpaceSm),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Videocam,
                    contentDescription = null,
                    tint = WaTextSecondary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(WaDimens.SpaceLg))
                Column {
                    Text(
                        text = "Tipo de llamada",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = WaTextPrimary
                    )
                    Text(
                        text = if (isVideoCall) "Video" else "Voz",
                        fontSize = 14.sp,
                        color = WaTextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(WaDimens.SpaceMd))

            // Toggle Requerir aprobación
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WaDimens.SpaceSm),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Group,
                    contentDescription = null,
                    tint = WaTextSecondary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(WaDimens.SpaceLg))
                Text(
                    text = "Requerir aprobación para unirse a la llamada",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = WaTextPrimary,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = requireApproval,
                    onCheckedChange = { requireApproval = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = WaGreen
                    )
                )
            }

            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))
            HorizontalDivider(color = Color(0xFFF0F2F5))
            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

            // Recordatorio
            ScheduleOptionRow(
                icon = Icons.Default.Notifications,
                title = "Recordatorio",
                subtitle = "15 minutos antes",
                onClick = { }
            )

            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

            // Organizado por
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WaDimens.SpaceSm),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = WaTextSecondary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(WaDimens.SpaceLg))
                Column {
                    Text(
                        text = "Organizado por",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = WaTextPrimary
                    )
                    Text(
                        text = "Ignacio Cardenas",
                        fontSize = 14.sp,
                        color = WaTextSecondary
                    )
                    Text(
                        text = "Tu nombre en WhatsApp. Edítalo en Ajustes.",
                        fontSize = 13.sp,
                        color = WaGreen
                    )
                }
            }

            Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

            // Nota informativa
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = WaDimens.SpaceSm),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Default.Security,
                    contentDescription = null,
                    tint = WaTextSecondary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(WaDimens.SpaceLg))
                Text(
                    text = "Tanto los invitados como WhatsApp podrán ver los detalles de la programación. Más información",
                    fontSize = 13.sp,
                    color = WaTextSecondary,
                    lineHeight = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
private fun ScheduleOptionRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WaDimens.RadiusMedium))
            .clickable { onClick() }
            .padding(vertical = WaDimens.SpaceSm),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = WaTextSecondary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(WaDimens.SpaceLg))
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = WaTextPrimary,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = subtitle,
            fontSize = 15.sp,
            color = WaTextSecondary
        )
    }
}
