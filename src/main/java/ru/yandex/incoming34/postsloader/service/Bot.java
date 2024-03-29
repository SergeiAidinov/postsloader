package ru.yandex.incoming34.postsloader.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Base64;
import java.util.List;
@Service
public class Bot extends TelegramLongPollingBot {

    /*@Value("${app.bot.token}")
    private String token;*/

    private String encodedString;

    @PostConstruct
    private void init() throws TelegramApiException {
        System.out.println("!@!!");
        encodedString = new String(Base64.getDecoder().decode("NzA4NjY3NDkwOTpBQUUzejB3d3Y0WTZYQzBEZlAwTi12cWl4bko0b3pfWnptVQ=="));
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return "postsloader_bot";
    }

    @Override
    public String getBotToken() {
        return "7086674909:AAE3z0wwv4Y6XC0DfP0N-vqixnJ4oz_ZzmU";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}
