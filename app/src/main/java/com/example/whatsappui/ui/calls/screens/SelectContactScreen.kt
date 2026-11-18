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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.calls.components.ContactAvatar
import com.example.whatsappui.ui.calls.model.CallSampleData
import com.example.whatsappui.ui.calls.model.Contact
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectContactScreen(
    contacts: List<Contact> = CallSampleData.sampleContacts,
    onBackClick: () -> Unit = {},
    onContactSelect: (Contact) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }

    val filteredContacts = remember(searchQuery, contacts) {
        if (searchQuery.isBlank()) {
            contacts
        } else {
            contacts.filter {
                it.name.contains(searchQuery, ignoreCase = true) ||
                        it.phoneNumber.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    val frequentContacts = remember(filteredContacts) {
        filteredContacts.filter { it.isFrequent }
    }
    val otherContacts = remember(filteredContacts) {
        filteredContacts.filter { !it.isFrequent }
    }

    Scaffold(
        topBar = {
            if (isSearching) {
                TopAppBar(
                    title = {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text("Buscar contacto...", color = WaTextSecondary) },
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
                        Column {
                            Text(
                                text = "Contactos",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = WaTextPrimary
                            )
                            Text(
                                text = "${contacts.size} contactos",
                                fontSize = 12.sp,
                                color = WaTextSecondary
                            )
                        }
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
                        IconButton(onClick = { isSearching = true }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = WaTextPrimary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
                )
            }
        },
        containerColor = Color.White
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Nota superior
            item {
                Text(
                    text = "Añade hasta 31 personas.",
                    fontSize = 13.sp,
                    color = WaTextSecondary,
                    modifier = Modifier.padding(horizontal = WaDimens.ScreenPadding, vertical = WaDimens.SpaceSm)
                )
            }

            // Opciones de cabecera
            item {
                ContactHeaderActionItem(
                    icon = Icons.Default.Link,
                    title = "Nuevo enlace de llamada",
                    onClick = { }
                )
            }

            item {
                ContactHeaderActionItem(
                    icon = Icons.Default.PersonAdd,
                    title = "Nuevo contacto",
                    trailingIcon = Icons.Default.QrCode,
                    onClick = { }
                )
            }

            // Sección Contactos frecuentes
            if (frequentContacts.isNotEmpty()) {
                item {
                    Text(
                        text = "Contactos frecuentes",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = WaTextSecondary,
                        modifier = Modifier.padding(
                            start = WaDimens.ScreenPadding,
                            end = WaDimens.ScreenPadding,
                            top = WaDimens.SpaceMd,
                            bottom = WaDimens.SpaceSm
                        )
                    )
                }

                items(frequentContacts, key = { it.id }) { contact ->
                    ContactRowItem(
                        contact = contact,
                        onClick = { onContactSelect(contact) }
                    )
                }
            }

            // Sección Contactos en WhatsApp
            if (otherContacts.isNotEmpty()) {
                item {
                    Text(
                        text = "Contactos en WhatsApp",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = WaTextSecondary,
                        modifier = Modifier.padding(
                            start = WaDimens.ScreenPadding,
                            end = WaDimens.ScreenPadding,
                            top = WaDimens.SpaceMd,
                            bottom = WaDimens.SpaceSm
                        )
                    )
                }

                items(otherContacts, key = { it.id }) { contact ->
                    ContactRowItem(
                        contact = contact,
                        onClick = { onContactSelect(contact) }
                    )
                }
            }
        }
    }
}

@Composable
private fun ContactHeaderActionItem(
    icon: ImageVector,
    title: String,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = WaDimens.ScreenPadding, vertical = WaDimens.SpaceSm),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(WaDimens.AvatarMedium)
                .clip(CircleShape)
                .background(WaGreen),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(WaDimens.SpaceMd))
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = WaTextPrimary,
            modifier = Modifier.weight(1f)
        )
        if (trailingIcon != null) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = null,
                tint = WaTextSecondary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun ContactRowItem(
    contact: Contact,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = WaDimens.ScreenPadding, vertical = WaDimens.SpaceSm),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactAvatar(
            name = contact.name,
            avatarColor = contact.avatarColor,
            size = WaDimens.AvatarMedium
        )
        Spacer(modifier = Modifier.width(WaDimens.SpaceMd))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = contact.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = WaTextPrimary
            )
            if (contact.status.isNotEmpty()) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = contact.status,
                    fontSize = 13.sp,
                    color = WaTextSecondary,
                    maxLines = 1
                )
            }
        }
        RadioButton(
            selected = false,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(unselectedColor = WaTextSecondary)
        )
    }
}
