package com.example.SpringDemoBot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("1")
public class StartMessage implements ActionOnMessage {
@Qualifier("telegramUtils")
    private final TelegramUtils tgUtils;

    public StartMessage(TelegramUtils tgUtils) {
        this.tgUtils = tgUtils;
    }

    @Override
    public SendMessage action(Update update) {
        long chatId = update.getMessage().getChatId();
        return tgUtils.startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
    }
}

