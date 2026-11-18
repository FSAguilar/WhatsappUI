package com.example.whatsappui.ui.calls

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.whatsappui.ui.calls.model.CallSampleData
import com.example.whatsappui.ui.calls.model.RecentCall
import com.example.whatsappui.ui.calls.screens.CallInfoScreen
import com.example.whatsappui.ui.calls.screens.CallsMainScreen
import com.example.whatsappui.ui.calls.screens.DialpadScreen
import com.example.whatsappui.ui.calls.screens.ScheduleCallScreen
import com.example.whatsappui.ui.calls.screens.SelectContactScreen

sealed class CallsScreenDestination {
    object Main : CallsScreenDestination()
    data class CallInfo(val call: RecentCall) : CallsScreenDestination()
    object ScheduleCall : CallsScreenDestination()
    object Dialpad : CallsScreenDestination()
    object SelectContact : CallsScreenDestination()
}

@Composable
fun CallsNavigationContainer() {
    val context = LocalContext.current
    var currentDestination by remember { mutableStateOf<CallsScreenDestination>(CallsScreenDestination.Main) }
    var recentCallsList by remember { mutableStateOf(CallSampleData.sampleRecentCalls) }

    when (val destination = currentDestination) {
        is CallsScreenDestination.Main -> {
            CallsMainScreen(
                recentCalls = recentCallsList,
                onNavigateToCallInfo = { selectedCall ->
                    currentDestination = CallsScreenDestination.CallInfo(selectedCall)
                },
                onNavigateToSelectContact = {
                    currentDestination = CallsScreenDestination.SelectContact
                },
                onNavigateToScheduleCall = {
                    currentDestination = CallsScreenDestination.ScheduleCall
                },
                onNavigateToDialpad = {
                    currentDestination = CallsScreenDestination.Dialpad
                },
                onShowFavorites = {
                    Toast.makeText(context, "Sección de Favoritos", Toast.LENGTH_SHORT).show()
                }
            )
        }

        is CallsScreenDestination.CallInfo -> {
            CallInfoScreen(
                call = destination.call,
                onBackClick = {
                    currentDestination = CallsScreenDestination.Main
                }
            )
        }

        is CallsScreenDestination.ScheduleCall -> {
            ScheduleCallScreen(
                onBackClick = {
                    currentDestination = CallsScreenDestination.Main
                },
                onSaveEvent = { newEvent ->
                    Toast.makeText(context, "Evento '${newEvent.title}' creado", Toast.LENGTH_SHORT).show()
                }
            )
        }

        is CallsScreenDestination.Dialpad -> {
            DialpadScreen(
                onBackClick = {
                    currentDestination = CallsScreenDestination.Main
                },
                onCallClick = { number ->
                    if (number.isNotBlank()) {
                        Toast.makeText(context, "Llamando a $number...", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }

        is CallsScreenDestination.SelectContact -> {
            SelectContactScreen(
                onBackClick = {
                    currentDestination = CallsScreenDestination.Main
                },
                onContactSelect = { contact ->
                    Toast.makeText(context, "Seleccionado: ${contact.name}", Toast.LENGTH_SHORT).show()
                    currentDestination = CallsScreenDestination.Main
                }
            )
        }
    }
}
