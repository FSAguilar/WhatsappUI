package com.example.whatsappui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.R
import com.example.whatsappui.data.ChatPreview
import com.example.whatsappui.ui.theme.*

@Composable
fun ChatRow(chat: ChatPreview) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceMd, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(WaDimens.SpaceMd)
    ) {
        Box(
            modifier = Modifier
                .size(WaDimens.AvatarMedium)
                .clip(CircleShape)
                .background(WaGreen.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            BasicText(
                text = chat.name.take(1).uppercase(),
                style = TextStyle(
                    color = WaGreen,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicText(
                    text = chat.name,
                    style = TextStyle(
                        color = WaTextPrimary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f, fill = false)
                )
                BasicText(
                    text = chat.time,
                    style = TextStyle(
                        color = if (chat.unreadCount > 0) WaGreenLight else WaTextSecondary,
                        fontSize = 12.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    if (chat.isOutgoing) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_main_double_check),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color(0xFF53BDEB)),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    BasicText(
                        text = chat.message,
                        style = TextStyle(
                            color = WaTextSecondary,
                            fontSize = 14.sp
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    if (chat.isMuted) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_main_mute),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color(0xFF667781)),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    if (chat.isPinned) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_main_pin),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    if (chat.unreadCount > 0) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .background(WaGreenLight),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = chat.unreadCount.toString(),
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
