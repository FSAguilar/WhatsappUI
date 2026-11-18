package com.example.whatsappui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaTextSecondary

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = WaDimens.SpaceMd)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFF0F2F5)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = WaDimens.SpaceMd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WaDimens.SpaceMd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_main_search),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            BasicText(
                text = stringResource(R.string.search_hint),
                style = TextStyle(
                    color = WaTextSecondary,
                    fontSize = 15.sp
                )
            )
        }
    }
}
