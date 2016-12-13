/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvybot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class MarvyBotApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MarvyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
}
