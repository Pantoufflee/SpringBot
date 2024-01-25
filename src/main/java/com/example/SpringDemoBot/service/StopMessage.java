package com.example.SpringDemoBot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("4")
public class StopMessage extends TelegramUtils implements ActionOnMessage {

    @Override
    public SendMessage action(Update update) {
        long chatId = update.getMessage().getChatId();
        return sendMessage(chatId, "You sent stop message");

    }
}

