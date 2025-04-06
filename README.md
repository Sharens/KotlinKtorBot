# Zadanie 3: Kotlin
* ✅ 3.0 Należy stworzyć aplikację kliencką w Kotlinie we frameworku Ktor, która pozwala na przesyłanie wiadomości na platformę Discord
* ❌ 3.5 Aplikacja jest w stanie odbierać wiadomości użytkowników z platformy Discord skierowane do aplikacji (bota)
* ❌ 4.0 Zwróci listę kategorii na określone żądanie użytkownika
* ❌ 4.5 Zwróci listę produktów wg żądanej kategorii
* ❌ 5.0 Aplikacja obsłuży dodatkowo jedną z platform: Slack, Messenger, Webex

## Konfiguracja

### Ustawienie zmiennej środowiskowej DISCORD_WEBHOOK_URL

Aby aplikacja mogła wysyłać wiadomości na Discorda, należy skonfigurować zmienną środowiskową `DISCORD_WEBHOOK_URL`. Wartość tej zmiennej to adres URL webhooka, który należy utworzyć na serwerze Discord.

**Kroki:**

1.  **Utwórz webhooka na serwerze Discord:**
    *   Przejdź do ustawień serwera Discord.
    *   W sekcji "Integracje" (Integrations) wybierz "Webhooki" (Webhooks).
    *   Kliknij "Utwórz webhook" (Create Webhook).
    *   Skonfiguruj webhooka (nazwa, kanał).
    *   Skopiuj adres URL webhooka.

2.  **Ustaw zmienną środowiskową:**
    *   **Tymczasowo (w terminalu):**
        ```bash
        export DISCORD_WEBHOOK_URL="YOUR_COPIED_WEBHOOK_URL"
        ```
        (Pamiętaj, aby zastąpić `YOUR_COPIED_WEBHOOK_URL` prawdziwym adresem URL webhooka.)
    *   **Na stałe (w pliku konfiguracyjnym):**
        *   Dodaj powyższą linię do pliku `~/.bashrc` lub `~/.zshrc` (w zależności od używanej powłoki).
        *   Po edycji pliku wykonaj komendę `source ~/.bashrc` lub `source ~/.zshrc`.

**Uwaga:** Pamiętaj, aby traktować adres URL webhooka jak hasło i nie udostępniać go publicznie.
