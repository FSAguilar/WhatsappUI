package com.example.whatsappui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.whatsappui.R
import com.example.whatsappui.data.MockData

@Composable
fun ChatsTab(onChatClick: (String) -> Unit = {}) {
    val allFilterText = stringResource(R.string.filter_all)
    var selectedFilter by rememberSaveable { mutableStateOf(allFilterText) }

    Column(Modifier.fillMaxSize()) {
        SearchBar()
        Spacer(Modifier.height(4.dp))
        FilterChips(
            selectedFilter = selectedFilter,
            onFilterSelected = { selectedFilter = it }
        )
        Spacer(Modifier.height(4.dp))
        ArchivedRow(count = 2)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(MockData.chats) { chat ->
                ChatRow(chat = chat, onClick = { onChatClick(it.name) })
            }
        }
    }
}
