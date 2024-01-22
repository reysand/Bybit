package com.reysand.bybit.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AnnouncementResponse(
    val result: AnnouncementResult
)

@Serializable
data class AnnouncementResult(
    val list: List<Announcement>
)
