package com.example.whatsappui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.R
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen

@Composable
fun TopBarMain(
    title: String = stringResource(R.string.app_name),
    onCameraClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = WaDimens.SpaceMd),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BasicText(
            text = title,
            style = TextStyle(
                color = WaGreen,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WaDimens.SpaceLg)
        ) {
            Box(modifier = Modifier.size(WaDimens.IconSize), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ic_main_camera),
                    contentDescription = null,
                    modifier = Modifier.size(WaDimens.IconSize)
                )
            }
            Box(modifier = Modifier.size(WaDimens.IconSize), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ic_main_menu),
                    contentDescription = null,
                    modifier = Modifier.size(WaDimens.IconSize)
                )
            }
        }
    }
}
