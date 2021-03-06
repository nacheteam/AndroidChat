package edu.galileo.android.androidchat.contactlist.ui;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by nacheteam on 10/06/16.
 */
public interface ContactListView {

    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);

}
