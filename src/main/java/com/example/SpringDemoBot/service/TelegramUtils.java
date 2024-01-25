package com.example.SpringDemoBot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.InputStream;

@Slf4j
@Component
public class TelegramUtils {

    public SendMessage startCommandReceived(long chatId, String name) {
        String answer = "Hi, " + name + ", nice to meet you!";
        log.info("Replied to user " + name);
        return sendMessage(chatId, answer);
    }

    public SendMessage sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        return message;
    }

    public SendPhoto sendPhoto(Update update, String chatId) {
//String path = "src\\main\\resources\\IMG_20190907_202559.jpg"; way 1
//File mediaFile = new File(path);
        InputStream resourceAsStream = getClass().getResourceAsStream("/IMG_20190907_202559.jpg"); //way 2 more correct
        InputFile photo = new InputFile(resourceAsStream, "IMG_20190907_202559.jpg");
        return SendPhoto.builder()
                .chatId(chatId)
                .photo(photo)
                .build();
    }

    public SendSticker sendSticker(Update update, String chatId) {
        String stickerFileId = update.getMessage().getSticker().getFileId();

        // Создание объекта InputFile из идентификатора стикера
        InputFile sticker = new InputFile(stickerFileId);

        // Создание объекта SendSticker с чатом и InputFile
        return SendSticker.builder()
                .chatId(chatId)
                .sticker(sticker)
                .build();
    }
}
