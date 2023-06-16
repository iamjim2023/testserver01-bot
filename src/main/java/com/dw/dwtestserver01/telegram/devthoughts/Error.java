package com.dw.dwtestserver01.telegram.devthoughts;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Error extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        String message = "";

        // Error Message --------------------------------------
        String errorMessage = "This command is not available";
        // ----------------------------------------------------
        // If you want to send a string message just modified the code below
        String name = "sample1";
        int age = 25;
        double salary = 5000.50;
        String formattedString = String.format("Name: %s, Age: %s, Salary: %.2f", name, age, salary);
        // ----------------------------------------------------

        switch (command) {
            case "/sample1":
                message = formattedString;
                break;
            case "/sample2":
                message = "Sample2";
                break;
            case "/sample3":
                message = "Sample3";
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