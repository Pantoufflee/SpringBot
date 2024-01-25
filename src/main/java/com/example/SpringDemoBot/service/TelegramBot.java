package com.example.SpringDemoBot.service;

import com.example.SpringDemoBot.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {


    private final BotConfig config;
    private final StartMessage stMsg;

    public TelegramBot(BotConfig config, StartMessage stMsg, List<ActionOnMessage> listOfKeys) {
        this.config = config;
        this.stMsg = stMsg;
        this.map = listOfKeys.stream()
                .collect(Collectors.toMap(b -> b.getClass().getAnnotation(Component.class).value(), b-> b));
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    private final Map<String, ActionOnMessage> map;

//    private void sendMessage (String str) {
//        System.out.println("was sent " + str);
//    }

    @Override
    public void onUpdateReceived(Update update) {
        String code = update.getMessage().getText();
        ActionOnMessage actionOnMessage = map.get(code);

        if (actionOnMessage == null) {
            throw new UnsupportedOperationException(code + " not supported yet");
        }
        //String str = actionOnMessage.action(update).toString();
        //sendMessage(str);

        //SendMessage action = stMsg.action(update);
//        try {
//            execute(actionOnMessage.action(update));
//        } catch (TelegramApiException e) {
//            log.error("Error occurred: " + e.getMessage());
//        }
    }

//            switch (messageText) {
//                case "/start" -> startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
//                case "/stop" -> sendMessage(chatId, "You sent stop message");
//                case "/sticker" -> {
//                    String sticker = "CAACAgIAAxkBAAMFZTFYr6ubmN4cR3o16JF6DnzUWRUAAhwJAAIj6gABSgq2IrIUh1e4MAQ";
//                    sendSticker(update, String.valueOf(chatId));
//                }
//                case "/photo" -> sendPhoto(update, String.valueOf(chatId));
//                default -> sendMessage(chatId, "Sorry, command wasn't recognized");
//            }








}
