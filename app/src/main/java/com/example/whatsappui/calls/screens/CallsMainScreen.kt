package com.example.whatsappui.calls.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Dialpad
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.calls.components.CallTypeIcon
import com.example.whatsappui.calls.components.ContactAvatar
import com.example.whatsappui.calls.components.QuickActionButton
import com.example.whatsappui.calls.model.CallSampleData
import com.example.whatsappui.calls.model.RecentCall
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaGreenLight
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallsMainScreen(
    recentCalls: List<RecentCall> = CallSampleData.sampleRecentCalls,
    onNavigateToCallInfo: (RecentCall) -> Unit = {},
    onNavigateToSelectContact: () -> Unit = {},
    onNavigateToScheduleCall: () -> Unit = {},
    onNavigateToDialpad: () -> Unit = {},
    onShowFavorites: () -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }

    val filteredCalls = remember(searchQuery, recentCalls) {
        if (searchQuery.isBlank()) {
            recentCalls
        } else {
            recentCalls.filter {
                it.contactName.contains(searchQuery, ignoreCase = true) ||
                        it.dateTime.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            if (isSearching) {
                TopAppBar(
                    title = {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text("Buscar llamadas...", color = WaTextSecondary) },
                            singleLine = true,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            isSearching = false
                            searchQuery = ""
                        }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Cerrar búsqueda",
                                tint = WaTextPrimary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
                )
            } else {
                TopAppBar(
                    title = {
                        Text(
                            text = "Llamadas",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = WaTextPrimary
                        )
                    },
                    actions = {
                        IconButton(onClick = { isSearching = true }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = WaTextPrimary
                            )
                        }
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
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToSelectContact,
                containerColor = WaGreenLight,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.PersonAdd,
                    contentDescription = "Nueva llamada",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        containerColor = Color.White
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                // Sección de Acciones Rápidas (Iconos superiores)
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WaDimens.SpaceSm, vertical = WaDimens.SpaceSm),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    QuickActionButton(
                        icon = Icons.Default.Phone,
                        label = "Llamar",
                        onClick = onNavigateToSelectContact
                    )
                    QuickActionButton(
                        icon = Icons.Default.CalendarToday,
                        label = "Programar",
                        onClick = onNavigateToScheduleCall
                    )
                    QuickActionButton(
                        icon = Icons.Default.Dialpad,
                        label = "Teclado",
                        onClick = onNavigateToDialpad
                    )
                    QuickActionButton(
                        icon = Icons.Default.FavoriteBorder,
                        label = "Favoritos",
                        onClick = onShowFavorites
                    )
                }
            }

            // Encabezado de sección
            item {
                Text(
                    text = "Recientes",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = WaTextPrimary,
                    modifier = Modifier.padding(horizontal = WaDimens.ScreenPadding, vertical = WaDimens.SpaceSm)
                )
            }

            // Lista de llamadas recientes
            items(filteredCalls, key = { it.id }) { call ->
                RecentCallItem(
                    call = call,
                    onItemClick = { onNavigateToCallInfo(call) },
                    onCallClick = { /* Simula llamada */ }
                )
            }
        }
    }
}
}


@Composable
fun RecentCallItem(
    call: RecentCall,
    onItemClick: () -> Unit,
    onCallClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(horizontal = WaDimens.ScreenPadding, vertical = WaDimens.SpaceSm),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactAvatar(
            name = call.contactName,
            avatarColor = call.avatarColor,
            size = WaDimens.AvatarMedium
        )
        Spacer(modifier = Modifier.width(WaDimens.SpaceMd))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = call.contactName,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = WaTextPrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                CallTypeIcon(callType = call.callType)
                Spacer(modifier = Modifier.width(WaDimens.SpaceXs))
                Text(
                    text = call.dateTime,
                    fontSize = 13.sp,
                    color = WaTextSecondary
                )
            }
        }
        IconButton(onClick = onCallClick) {
            Icon(
                imageVector = if (call.isVideo) Icons.Default.Videocam else Icons.Default.Phone,
                contentDescription = if (call.isVideo) "Llamada de video" else "Llamada de voz",
                tint = WaGreen,
                modifier = Modifier.size(22.dp)
            )
        }
    }
}
