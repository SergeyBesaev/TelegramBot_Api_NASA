package com.example.nasaapibot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class NasaApiBotApplication {
    public static void main(String[] args) {

        try {
            TelegramBotsApi nasaApiBot = new TelegramBotsApi(DefaultBotSession.class);
            nasaApiBot.registerBot(new TelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}