/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvybot;

import org.telegram.telegrambots.api.methods.send.SendMessage;


public interface MarvyBotListener {
    void onMessageRecieved(String from,String message);

    void onReplySent(SendMessage Message);
}
