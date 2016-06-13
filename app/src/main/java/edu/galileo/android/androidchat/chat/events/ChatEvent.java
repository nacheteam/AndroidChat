package edu.galileo.android.androidchat.chat.events;

import edu.galileo.android.androidchat.entities.ChatMessage;

/**
 * Created by nacheteam on 12/06/16.
 */
public class ChatEvent {

    ChatMessage message;

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}
