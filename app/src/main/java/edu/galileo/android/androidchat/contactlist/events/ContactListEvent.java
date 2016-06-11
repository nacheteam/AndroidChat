package edu.galileo.android.androidchat.contactlist.events;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by nacheteam on 10/06/16.
 */
public class ContactListEvent {

    public final static int OnContactAdded = 0;
    public final static int OnContactChanged = 1;
    public final static int OnContactRemoved = 2;

    private User user;
    private int eventType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
