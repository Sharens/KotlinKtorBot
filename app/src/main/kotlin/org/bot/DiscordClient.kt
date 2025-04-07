package org.bot

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val productcategories: Map<String, List<String>> = mapOf(
    "laptop" to listOf("HP", "Lenovo", "Apple"), 
    "computer" to listOf("Gaming", "Work"), 
    "dryer" to listOf("Dyson", "Parlux")
)

class DiscordClient {
    private val client = HttpClient(CIO) {
        install (ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    @Serializable
    data class DiscordMessage(val content:String)

    suspend fun sendMessage(webhookUrl: String, message: DiscordMessage) {
        client.post(webhookUrl) {
            contentType(ContentType.Application.Json)   
            setBody(message)
        }
    }
}