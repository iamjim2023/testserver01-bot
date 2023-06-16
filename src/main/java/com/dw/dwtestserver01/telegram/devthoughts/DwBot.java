package com.dw.dwtestserver01.telegram.devthoughts;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DwBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        String message = "";

        String jimuel = "hi :)";
        String peter = "Full Stack Developer";
        String rinier = "Frontend Developer";
        String nathaniel = "Backend Developer";
        String dannalyn = "Backend Developer";
        String start = "Welcome to the Telegram bot!";
        String whoami = "I am an Artificial Intelligent Bot, an AI Bot message model developed and configured by Jimuel Madlangsakay. I'm here to provide information. Is there something specific you would like to know?";
        String errorMessage = "This command is not available.";

        switch (command) {
            case "/jimuel":
                message = jimuel;
                break;
            case "/peter":
                message = peter;
                break;
            case "/rinier":
                message = rinier;
                break;
            case "/nathaniel":
                message = nathaniel;
                break;
            case "/dannalyn":
                message = dannalyn;
                break;
            case "/start":
                message = start;
                break;
            case "/whoami":
                message = whoami;
                break;
            default:
                message = errorMessage;
                break;
        }

        SendMessage response = new SendMessage();
        response.setChatId(update.getMessage().getChatId().toString());
        response.setText(message);

        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "dowinnbot";
    }

    @Override
    public String getBotToken() {
        return "5636236097:AAFbbizXgzIjO2F5SLD7q79uhVMQqJpQPe4";
    }
}
