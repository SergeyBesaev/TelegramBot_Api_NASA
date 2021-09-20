package com.example.nasaapibot;

import com.example.nasaapibot.Model.MarsModel.MarsPhotoModel;
import com.example.nasaapibot.Model.MarsModel.Photo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    private final static String TOKEN = "****";
    private final static String USERNAME = "NasaApiTelegram_bot";

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        ObjectMapper mapper = new ObjectMapper();

        InputStream fileMars = new URL(NasaApi.urlMARS()).openStream();
        MarsPhotoModel photoModel = mapper.readValue(fileMars, MarsPhotoModel.class);

        fileMars.close();

        if (update.hasMessage() && update.getMessage().getText().equals("/new_photo")) {

            SendMediaGroup sendMediaGroup = new SendMediaGroup();
            List<InputMedia> list = new ArrayList<>();
            sendMediaGroup.setChatId(update.getMessage().getChatId().toString());
            sendMediaGroup.setMedias(list);

            for (int i = 0; i < 10; i++) {

            Photo photo = photoModel.getPhotos().get(i);
            String path = photo.getImgSrc();

            InputMediaPhoto inputMediaPhoto = new InputMediaPhoto();
            inputMediaPhoto.setMedia(path);
            inputMediaPhoto.setCaption("Земная дата: " + photo.getEarthDate() + "\n" + "Марсоход: " + photo.getRover().getName() + "\n" + "Камера: " + photo.getCamera().getName());

            list.add(inputMediaPhoto);

            }

            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Хочешь фото за определенную дату? Пришли в ответ дату в формате:" + "\n" + "2015-9-18" + "\n" + "Фото доступны с 2012-8-18");

            try {
                execute(sendMediaGroup); // Call method to send the message
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        else if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Привет, человек! " + "\n" + "\n" + "Свежие фото Марса доступны в меню" + "\n" + " /new_photo " + "\n" + "\n" + "Хочешь фото за определенную дату? Пришли в ответ дату в формате:" + "\n" + "2015-9-18" + "\n" + "Фото доступны с 2012-8-18");

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        else if (update.hasMessage() && update.getMessage().hasText()) {

            String userDate = update.getMessage().getText();
            InputStream fileMars1 = new URL(NasaApi.urlMARS(userDate)).openStream();
            MarsPhotoModel photoModel1 = mapper.readValue(fileMars1, MarsPhotoModel.class);
            fileMars1.close();


            SendMediaGroup sendMediaGroup1 = new SendMediaGroup();
            List<InputMedia> list1 = new ArrayList<>();
            sendMediaGroup1.setChatId(update.getMessage().getChatId().toString());
            sendMediaGroup1.setMedias(list1);

            for (int i = 0; i < 10; i++) {

                Photo photo = photoModel1.getPhotos().get(i);
                String path = photo.getImgSrc();

                InputMediaPhoto inputMediaPhoto = new InputMediaPhoto();
                inputMediaPhoto.setMedia(path);
                inputMediaPhoto.setCaption("Земная дата: " + photo.getEarthDate() + "\n" + "Марсоход: " + photo.getRover().getName() + "\n" + "Камера: " + photo.getCamera().getName());

                list1.add(inputMediaPhoto);

            }

            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Хочешь фото за определенную дату? Пришли в ответ дату в формате:" + "\n" + "2015-9-18" + "\n" + "Фото доступны с 2012-8-18");

            try {
                execute(sendMediaGroup1); // Call method to send the message
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        }
    }