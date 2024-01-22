package com.reysand.bybit.data.util

import java.util.Calendar
import java.util.Locale

object AnnouncementDateFormatter {
    fun format(dateTimestamp: Long): String {
        val date = Calendar.getInstance().apply { timeInMillis = dateTimestamp }

        val displayMonth = date.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
        val dayOfMonth = date.get(Calendar.DAY_OF_MONTH)

        return "$displayMonth $dayOfMonth, ${date.get(Calendar.YEAR)}"
    }
}