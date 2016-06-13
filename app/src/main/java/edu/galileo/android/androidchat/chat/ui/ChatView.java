package edu.galileo.android.androidchat.chat.ui;

import edu.galileo.android.androidchat.entities.ChatMessage;

/**
 * Created by nacheteam on 12/06/16.
 */
public interface ChatView {

    void onMessageReceived(ChatMessage msg);

}
