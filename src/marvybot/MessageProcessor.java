/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvybot;

public class MessageProcessor {

    public MessageProcessor() {
    }
    
    public static String getReply(String message)
    {
        message= message.toLowerCase();
        String reply="? i'am still learning";
        
        if(message.equals("hii"))
        {
            reply="Hello";
        }
        if(message.equals("how are you"))
        {
            reply="Am fine dear, how are you too?";
        }
        if(message.equals("same here"))
        {
            reply="gud to hear";
        }
        if(message.equals("bye"))
        {
            reply="Bye bye";
        }
        if(message.equals("miss u"))
        {
            reply="love u";
        }
         if(message.equals("hauwa"))
        {
            reply="she is beautiful";
        }
        return reply;
    }
    
}
