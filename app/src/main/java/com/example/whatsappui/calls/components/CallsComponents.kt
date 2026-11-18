package com.example.whatsappui.calls.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CallMade
import androidx.compose.material.icons.automirrored.filled.CallMissed
import androidx.compose.material.icons.automirrored.filled.CallReceived
import androidx.compose.material3.Icon
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
import com.example.whatsappui.calls.model.CallType
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaRed
import com.example.whatsappui.ui.theme.WaTextPrimary

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
