# Zadanie 3: Kotlin

* ✅ 3.0 Należy stworzyć aplikację kliencką w Kotlinie we frameworku Ktor, która pozwala na przesyłanie wiadomości na platformę Discord
* ✅ 3.5 Aplikacja jest w stanie odbierać wiadomości użytkowników z platformy Discord skierowane do aplikacji (bota)
* ✅ 4.0 Zwróci listę kategorii na określone żądanie użytkownika
* ❌ 4.5 Zwróci listę produktów wg żądanej kategorii
* ❌ 5.0 Aplikacja obsłuży dodatkowo jedną z platform: Slack, Messenger, Webex

## Konfiguracja

### Ustawienie zmiennych środowiskowych

Aby aplikacja mogła działać poprawnie, należy skonfigurować następujące zmienne środowiskowe:

#### DISCORD_WEBHOOK_URL

Ta zmienna zawiera adres URL webhooka, który należy utworzyć na serwerze Discord. Webhook ten będzie używany do wysyłania wiadomości przez aplikację.

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

#### DISCORD_BOT_TOKEN

Ta zmienna zawiera token Twojego bota Discorda. Token ten jest używany do uwierzytelnienia bota na platformie Discord i umożliwia mu nasłuchiwanie wiadomości.

**Kroki:**

1.  **Utwórz bota w Discord Developer Portal:**
    *   Przejdź na stronę Discord Developer Portal.
    *   Zaloguj się na swoje konto Discord.
    *   Kliknij "New Application".
    *   Wpisz nazwę aplikacji i kliknij "Create".
    *   W menu po lewej stronie przejdź do zakładki "Bot".
    *   Kliknij "Add Bot".
    *   Skopiuj token bota.

2.  **Ustaw zmienną środowiskową:**
    *   **Tymczasowo (w terminalu):**
        ```bash
        export DISCORD_BOT_TOKEN="YOUR_COPIED_BOT_TOKEN"
        ```
        (Pamiętaj, aby zastąpić `YOUR_COPIED_BOT_TOKEN` prawdziwym tokenem bota.)
    *   **Na stałe (w pliku konfiguracyjnym):**
        *   Dodaj powyższą linię do pliku `~/.bashrc` lub `~/.zshrc` (w zależności od używanej powłoki).
        *   Po edycji pliku wykonaj komendę `source ~/.bashrc` lub `source ~/.zshrc`.

**Uwaga:** Pamiętaj, aby traktować token bota jak hasło i nie udostępniać go publicznie.

### Dodanie bota na serwer
1. Przejdź do zakładki OAuth2 -> URL Generator
2. Zaznacz bot i administrator
3. Skopiuj wygenerowany link i wklej go w przeglądarce
4. Wybierz serwer na który chcesz dodać bota
