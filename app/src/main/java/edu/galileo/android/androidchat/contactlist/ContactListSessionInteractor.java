package edu.galileo.android.androidchat.contactlist;

/**
 * Created by nacheteam on 10/06/16.
 */
public interface ContactListSessionInteractor {

    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);

}
