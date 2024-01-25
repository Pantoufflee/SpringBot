package com.example.SpringDemoBot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Component("2")
public class Sticker implements ActionOnMessage {
    @Qualifier("telegramUtils")
    private final TelegramUtils tgUtils;

    public Sticker(TelegramUtils tgUtils) {
        this.tgUtils = tgUtils;
    }

    @Override
    public SendSticker action(Update update) {
        long chatId = update.getMessage().getChatId();
        return tgUtils.sendSticker(update, String.valueOf(chatId));
    }
}
