package com.example.whatsappui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaTextPrimary

@Composable
fun FilterChips(
    selectedFilter: String,
    onFilterSelected: (String) -> Unit
) {
    val filters = listOf(
        stringResource(R.string.filter_all),
        stringResource(R.string.filter_unread),
        stringResource(R.string.filter_favorites),
        stringResource(R.string.filter_groups)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = WaDimens.SpaceMd, vertical = WaDimens.SpaceSm),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        filters.forEach { filter ->
            val isSelected = filter == selectedFilter
            val backgroundColor = if (isSelected) Color(0xFFE8F5E9) else Color(0xFFF0F2F5)
            val textColor = if (isSelected) WaGreen else WaTextPrimary
            val borderColor = if (isSelected) WaGreen.copy(alpha = 0.3f) else Color.Transparent

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(backgroundColor)
                    .border(1.dp, borderColor, RoundedCornerShape(50))
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                BasicText(
                    text = filter,
                    style = TextStyle(
                        color = textColor,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}
