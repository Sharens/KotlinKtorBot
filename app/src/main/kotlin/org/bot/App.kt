package org.bot

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent

fun main() {
    val discordClient = DiscordClient()
    val webhookUrl = System.getenv("DISCORD_WEBHOOK_URL") ?: throw IllegalStateException("DISCORD_WEBHOOK_URL environment variable is not set")
    val botToken = System.getenv("DISCORD_BOT_TOKEN") ?: throw IllegalStateException("DISCORD_BOT_TOKEN environment variable is not set")

    val jda = JDABuilder.createDefault(botToken)
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .addEventListeners(object : ListenerAdapter() {
            override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent){
                when (event.name) {
                    "hello" -> {
                        event.deferReply(true).queue()
                        event.hook.sendMessage("Wysłano wiadomość hello world").queue()
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                discordClient.sendMessage(webhookUrl, DiscordClient.DiscordMessage("Hello World!"))
                            } catch (e: Exception) {
                                println("Błąd wysyłania wiadomości")
                            }
                        }
                    }
                    "categories" -> {
                        event.deferReply(true).queue()
                        event.hook.sendMessage("Wysłano wiadomość dostępne kategorie").queue()
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                discordClient.sendMessage(webhookUrl, DiscordClient.DiscordMessage("Lista kategorii: ${productcategories.keys.joinToString(", ")}"))
                            } catch (e: Exception) {
                                println("Błąd wysyłania wiadomości")
                            }
                        }
                    }
                    "cat_laptops" -> {
                        event.deferReply(true).queue()
                        event.hook.sendMessage("Ukazano dostępne laptopy").queue()
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                val laptops = productcategories["laptop"] ?: emptyList()
                                val message = if (laptops.isNotEmpty()){
                                    "Dostępne laptopy: ${laptops.joinToString(", ")}"
                                } else {
                                    "Brak dostępnych laptopów"
                                }
                                discordClient.sendMessage(webhookUrl, DiscordClient.DiscordMessage(message))
                            } catch (e: Exception) {
                                println("Błąd wysyłania wiadomości")
                            }
                        }
                    }
                    "cat_computers" -> {
                        event.deferReply(true).queue()
                        event.hook.sendMessage("Ukazano dostępne komputery").queue()
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                val computers = productcategories["computer"] ?: emptyList()
                                val message = if (computers.isNotEmpty()){
                                    "Dostępne komputery: ${computers.joinToString(", ")}"
                                } else {
                                    "Brak dostępnych komputerów"
                                }
                                discordClient.sendMessage(webhookUrl, DiscordClient.DiscordMessage(message))
                            } catch (e: Exception) {
                                println("Błąd wysyłania wiadomości")
                            }
                        }
                    }
                    "cat_dryers" -> {
                        event.deferReply(true).queue()
                        event.hook.sendMessage("Ukazano dostępne suszarki").queue()
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                val dryers = productcategories["dryer"] ?: emptyList()
                                val message = if (dryers.isNotEmpty()){
                                    "Dostępne suszarki: ${dryers.joinToString(", ")}"
                                } else {
                                    "Brak dostępnych suszarek"
                                }
                                discordClient.sendMessage(webhookUrl, DiscordClient.DiscordMessage(message))
                            } catch (e: Exception) {
                                println("Błąd wysyłania wiadomości")
                            }
                        }
                    }
                }
            }
        })
        .build()
        .updateCommands()
        .addCommands(
            Commands.slash("hello", "Wysyła użytkownikowi wiadomość hello world"),
            Commands.slash("categories", "Wysyła użytkownikowi listę kategorii"),
            Commands.slash("cat_laptops", "Wyświetla dostępne laptopy"),
            Commands.slash("cat_computers", "Wyświetla dostępne komputery"),
            Commands.slash("cat_dryers", "Wyświetla dostępne suszarki")
        )
        .queue()
    println("Bot został uruchomiony")
}
