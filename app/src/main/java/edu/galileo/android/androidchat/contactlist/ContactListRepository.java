package edu.galileo.android.androidchat.contactlist;

/**
 * Created by nacheteam on 10/06/16.
 */
public interface ContactListRepository {

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void subscribeToContactListEvents();
    void unsubscribeToContactListEvents();
    void destroyListener();
    void changeConnectionStatus(boolean online);

}
