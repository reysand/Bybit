package com.reysand.bybit.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.reysand.bybit.ui.components.AnnouncementListItem
import com.reysand.bybit.ui.viewmodel.BybitViewModel

@Composable
fun HomeScreen(bybitViewModel: BybitViewModel) {

    val announcementList by bybitViewModel.announcementList.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.Top
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(announcementList) { announcement ->
            AnnouncementListItem(announcement = announcement)
            Log.d("HomeScreen", "announcementList: ${announcement.title}")
        }
    }
}