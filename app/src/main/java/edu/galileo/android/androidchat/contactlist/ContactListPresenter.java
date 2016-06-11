package edu.galileo.android.androidchat.contactlist;

import edu.galileo.android.androidchat.contactlist.events.ContactListEvent;

/**
 * Created by nacheteam on 10/06/16.
 */
public interface ContactListPresenter {

    void onCreate();
    void onDestroy();
    void onPause();
    void onResume();

    void SignOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);

}
