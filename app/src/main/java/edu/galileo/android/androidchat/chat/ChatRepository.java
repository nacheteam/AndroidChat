package edu.galileo.android.androidchat.chat;

/**
 * Created by nacheteam on 12/06/16.
 */
public interface ChatRepository {

    void onChangeConnectionStatus(boolean online);
    void sendMessage(String msg);
    void setRecipient(String recipient);

    void subscribe();
    void unsubscribe();
    void destroyListener();

}
