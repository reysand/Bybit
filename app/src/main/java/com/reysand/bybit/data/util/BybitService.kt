package com.reysand.bybit.data.util

import android.util.Log
import com.reysand.bybit.data.model.AnnouncementResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

class BybitService {

    private val url = "https://api.bybit.com/v5/announcements/index?locale=en-US&limit=10"

    /**
     * The Ktor HTTP client used to fetch the announcement data.
     */
    private val ktorHttpClient = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json { ignoreUnknownKeys = true })
        }
    }

    /**
     * Fetches the announcement data from the Bybit API.
     */
    suspend fun fetchData(): AnnouncementResponse {
        val result: AnnouncementResponse = ktorHttpClient.get(url)
        Log.d("BybitService", "fetchData: $result")
        return result
    }
}