package org.bot

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent
import kotlinx.coroutines.runBlocking

fun main() {
    val discordClient = DiscordClient()
    val webhookUrl = System.getenv("DISCORD_WEBHOOK_URL") ?: throw IllegalStateException("DISCORD_WEBHOOK_URL environment variable is not set")
    val botToken = System.getenv("DISCORD_BOT_TOKEN") ?: throw IllegalStateException("DISCORD_BOT_TOKEN environment variable is not set")

    val jda = JDABuilder.createDefault(botToken)
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .addEventListeners(object : ListenerAdapter() {
            override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent){
                if (event.name == "hello") {
                        event.deferReply(true).queue()
                        event.hook.sendMessage("Wysłano wiadomość hello world").queue()
                        runBlocking {
                            discordClient.sendMessage(webhookUrl, DiscordClient.DiscordMessage("Hello World!"))
                        }
                }
            }
        })
        .build().updateCommands().addCommands(
            Commands.slash("hello", "Wysyła użytkownikowi wiadomość hello world")
        ).queue()
    println("Bot został uruchomiony")
}
