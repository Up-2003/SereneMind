package com.serenemind.api

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiService {
    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun fetchDataFromSpringBoot(): String {
        return try {
            // Emulator အတွက် localhost အစား 10.0.2.2 ကို သုံးရပါမယ်
            val response: HttpResponse = httpClient.get("http://192.168.90.35:8080/api/auth/data")
            response.bodyAsText()
        } catch (e: Exception) {
            "Error: ${e.localizedMessage}"
            
        }
    }
}