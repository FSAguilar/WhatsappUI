package com.example.whatsappui.ui.calls.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CallMade
import androidx.compose.material.icons.automirrored.filled.CallMissed
import androidx.compose.material.icons.automirrored.filled.CallReceived
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.calls.model.CallType
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaRed
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary

@Composable
fun ContactAvatar(
    name: String,
    avatarColor: Color,
    modifier: Modifier = Modifier,
    size: Dp = WaDimens.AvatarMedium
) {
    val initial = if (name.isNotBlank()) name.trim().take(1).uppercase() else "?"
    val textSize = when {
        size >= 100.dp -> 44.sp
        size >= 50.dp -> 20.sp
        else -> 16.sp
    }

    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(avatarColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initial,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = textSize
        )
    }
}

@Composable
fun CallTypeIcon(
    callType: CallType,
    modifier: Modifier = Modifier
) {
    val icon: ImageVector = when (callType) {
        CallType.OUTGOING -> Icons.AutoMirrored.Filled.CallMade
        CallType.INCOMING -> Icons.AutoMirrored.Filled.CallReceived
        CallType.MISSED -> Icons.AutoMirrored.Filled.CallMissed
    }
    val color: Color = when (callType) {
        CallType.OUTGOING -> WaGreen
        CallType.INCOMING -> WaGreen
        CallType.MISSED -> WaRed
    }

    Icon(
        imageVector = icon,
        contentDescription = callType.name,
        tint = color,
        modifier = modifier.size(16.dp)
    )
}

@Composable
fun QuickActionButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(RoundedCornerShape(WaDimens.RadiusMedium))
            .clickable { onClick() }
            .padding(vertical = WaDimens.SpaceSm, horizontal = WaDimens.SpaceSm)
    ) {
        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0F2F5)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = WaTextPrimary,
                modifier = Modifier.size(WaDimens.IconSize)
            )
        }
        Spacer(modifier = Modifier.height(WaDimens.SpaceXs))
        Text(
            text = label,
            fontSize = 13.sp,
            color = WaTextPrimary,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun CallsBottomNavigation(
    selectedTab: Int = 3,
    onTabSelected: (Int) -> Unit = {}
) {
    Surface(
        color = Color(0xFFF7F8FA),
        shadowElevation = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Default.Chat,
                label = "Chats",
                isSelected = selectedTab == 0,
                badgeCount = 1,
                onClick = { onTabSelected(0) }
            )
            BottomNavItem(
                icon = Icons.Default.Update,
                label = "Novedades",
                isSelected = selectedTab == 1,
                onClick = { onTabSelected(1) }
            )
            BottomNavItem(
                icon = Icons.Default.Groups,
                label = "Comunidades",
                isSelected = selectedTab == 2,
                onClick = { onTabSelected(2) }
            )
            BottomNavItem(
                icon = Icons.Default.Phone,
                label = "Llamadas",
                isSelected = selectedTab == 3,
                onClick = { onTabSelected(3) }
            )
        }
    }
}

@Composable
private fun BottomNavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    badgeCount: Int = 0,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isSelected) Color(0xFFD3E3FD) else Color.Transparent)
                    .padding(horizontal = 20.dp, vertical = 4.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = if (isSelected) WaGreen else WaTextSecondary,
                    modifier = Modifier.size(24.dp)
                )
            }
            if (badgeCount > 0) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(WaGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = badgeCount.toString(),
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) WaTextPrimary else WaTextSecondary
        )
    }
}
