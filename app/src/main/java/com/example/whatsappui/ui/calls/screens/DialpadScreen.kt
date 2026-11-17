package com.example.whatsappui.ui.calls.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappui.ui.theme.WaDimens
import com.example.whatsappui.ui.theme.WaGreen
import com.example.whatsappui.ui.theme.WaTextPrimary
import com.example.whatsappui.ui.theme.WaTextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialpadScreen(
    onBackClick: () -> Unit = {},
    onCallClick: (String) -> Unit = {}
) {
    var phoneNumber by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
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
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WaDimens.ScreenPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Display de número
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = phoneNumber,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = WaTextPrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .width(3.dp)
                            .height(36.dp)
                            .background(WaGreen)
                    )
                }

                if (phoneNumber.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            if (phoneNumber.isNotEmpty()) {
                                phoneNumber = phoneNumber.dropLast(1)
                            }
                        },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Backspace,
                            contentDescription = "Borrar",
                            tint = WaTextSecondary
                        )
                    }
                }
            }

            // Teclado numérico
            Column(
                modifier = Modifier.padding(bottom = WaDimens.SpaceLg),
                verticalArrangement = Arrangement.spacedBy(WaDimens.SpaceMd)
            ) {
                DialpadRow(
                    keys = listOf(
                        DialpadKeyData("1", ""),
                        DialpadKeyData("2", "ABC"),
                        DialpadKeyData("3", "DEF")
                    ),
                    onKeyPress = { phoneNumber += it }
                )
                DialpadRow(
                    keys = listOf(
                        DialpadKeyData("4", "GHI"),
                        DialpadKeyData("5", "JKL"),
                        DialpadKeyData("6", "MNO")
                    ),
                    onKeyPress = { phoneNumber += it }
                )
                DialpadRow(
                    keys = listOf(
                        DialpadKeyData("7", "PQRS"),
                        DialpadKeyData("8", "TUV"),
                        DialpadKeyData("9", "WXYZ")
                    ),
                    onKeyPress = { phoneNumber += it }
                )
                DialpadRow(
                    keys = listOf(
                        DialpadKeyData("*", ""),
                        DialpadKeyData("0", "+"),
                        DialpadKeyData("#", "")
                    ),
                    onKeyPress = { phoneNumber += it },
                    onLongPressZero = { phoneNumber += "+" }
                )

                Spacer(modifier = Modifier.height(WaDimens.SpaceLg))

                // Botón verde de llamada
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(68.dp)
                            .clip(CircleShape)
                            .background(WaGreen)
                            .clickable { onCallClick(phoneNumber) },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Llamar",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}

private data class DialpadKeyData(
    val digit: String,
    val letters: String
)

@Composable
private fun DialpadRow(
    keys: List<DialpadKeyData>,
    onKeyPress: (String) -> Unit,
    onLongPressZero: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        keys.forEach { keyData ->
            DialpadKey(
                digit = keyData.digit,
                letters = keyData.letters,
                onClick = { onKeyPress(keyData.digit) },
                onLongClick = if (keyData.digit == "0" && onLongPressZero != null) onLongPressZero else null
            )
        }
    }
}

@Composable
private fun DialpadKey(
    digit: String,
    letters: String,
    onClick: () -> Unit,
    onLongClick: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .size(76.dp)
            .clip(CircleShape)
            .background(Color(0xFFF0F2F5))
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onClick() },
                    onLongPress = { onLongClick?.invoke() }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = digit,
                fontSize = 28.sp,
                fontWeight = FontWeight.Normal,
                color = WaTextPrimary
            )
            if (letters.isNotEmpty()) {
                Text(
                    text = letters,
                    fontSize = 11.sp,
                    color = WaTextSecondary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
