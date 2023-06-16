package com.dw.dwtestserver01.telegram.devthoughts;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String [] args){
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            Uncomment the API that you want to run the message in telegram

//            botsApi.registerBot(new DwBot());
            botsApi.registerBot(new Error());
//            botsApi.registerBot(new Debugging());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
