package edu.galileo.android.androidchat.addcontact;

import edu.galileo.android.androidchat.addcontact.event.AddContactEvent;

/**
 * Created by nacheteam on 11/06/16.
 */
public interface AddContactPresenter {

    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);

}
