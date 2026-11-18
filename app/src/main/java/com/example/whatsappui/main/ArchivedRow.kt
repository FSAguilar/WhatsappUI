package com.example.whatsappui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaTextPrimary

@Composable
fun ArchivedRow(count: Int = 2) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WaDimens.SpaceMd, vertical = WaDimens.SpaceSm),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WaDimens.SpaceLg)
        ) {
            Box(
                modifier = Modifier.size(WaDimens.AvatarSmall),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_main_archived),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            BasicText(
                text = stringResource(R.string.archived),
                style = TextStyle(
                    color = WaTextPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        BasicText(
            text = count.toString(),
            style = TextStyle(
                color = WaGreen,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
