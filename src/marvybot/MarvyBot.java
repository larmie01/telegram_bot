/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvybot;



import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MarvyBot extends TelegramLongPollingBot{

    private List<MarvyBotListener> listeners = new ArrayList<MarvyBotListener>();
    public void addListener(MarvyBotListener toAdd) {
        listeners.add(toAdd);
    }
    
    @Override
    public String getBotToken() {
        return Constants.token;
    }

    @Override
    public void onUpdateReceived(Update update) 
    {
        // We check if the update has a message and the message has text
        
        
        if (update.hasMessage() && update.getMessage().hasText()) 
        {
        
            String message;
            message = update.getMessage().getText();

            for (MarvyBotListener hl : listeners)
            {
                hl.onMessageRecieved(update.getMessage().getFrom().getFirstName(),message);
            }
            
            String reply =MessageProcessor.getReply(message);  

            sendReply(reply,update.getMessage().getChatId());
        }
    }
    
    void sendReply(String reply,long chatId)
    {
        SendMessage Message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(chatId)
                    .setText(reply);

            try {
                sendMessage(Message); // Call method to send the message
                
                for (MarvyBotListener hl : listeners)
                {
                    hl.onReplySent(Message);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            
    }

    @Override
    public String getBotUsername() {
        return Constants.botUsername;
    }


    
}
