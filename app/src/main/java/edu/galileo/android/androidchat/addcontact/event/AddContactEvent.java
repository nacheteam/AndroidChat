package edu.galileo.android.androidchat.addcontact.event;

/**
 * Created by nacheteam on 11/06/16.
 */
public class AddContactEvent {

    boolean error = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
