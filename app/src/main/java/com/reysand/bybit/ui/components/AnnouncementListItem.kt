package com.reysand.bybit.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.reysand.bybit.data.model.Announcement
import com.reysand.bybit.data.util.AnnouncementDateFormatter

@Composable
fun AnnouncementListItem(announcement: Announcement) {
    Card {
        Text(text = announcement.title, fontWeight = FontWeight.Bold)
        Text(text = announcement.description)
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                    alignment = Alignment.Start
                ),
            ) {
                items(announcement.tags) { tag ->
                    Card {
                        Text(text = tag, fontStyle = FontStyle.Italic)
                    }
                }
            }
            Text(text = AnnouncementDateFormatter.format(announcement.dateTimestamp))
        }
    }
}
