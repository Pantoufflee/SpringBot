package com.example.SpringDemoBot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("3")
public class Photo implements ActionOnMessage{
    @Qualifier("telegramUtils")
    private final TelegramUtils tgUtils;

    public Photo(TelegramUtils tgUtils) {
        this.tgUtils = tgUtils;
    }

    @Override
    public SendPhoto action(Update update) {
        long chatId = update.getMessage().getChatId();
        return tgUtils.sendPhoto(update, String.valueOf(chatId));
    }
}
