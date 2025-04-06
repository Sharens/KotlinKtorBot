package org.bot
import kotlinx.coroutines.runBlocking

fun main() {
    val discordClient = DiscordClient()
    val webhookUrl = System.getenv("DISCORD_WEBHOOK_URL") ?: throw IllegalStateException("DISCORD_WEBHOOK_URL environment variable is not set")


    runBlocking {
        discordClient.sendMessage(webhookUrl, DiscordClient.DiscordMessage("Hello World!"))
    }
}
