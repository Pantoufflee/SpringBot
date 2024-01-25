package com.example.SpringDemoBot.service;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface ActionOnMessage {
    PartialBotApiMethod action(Update update);  //messageText
}
