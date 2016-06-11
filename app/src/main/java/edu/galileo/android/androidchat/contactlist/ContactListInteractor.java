package edu.galileo.android.androidchat.contactlist;

/**
 * Created by nacheteam on 10/06/16.
 */
public interface ContactListInteractor {

    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);

}
