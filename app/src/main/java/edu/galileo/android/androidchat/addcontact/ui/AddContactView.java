package edu.galileo.android.androidchat.addcontact.ui;

/**
 * Created by nacheteam on 11/06/16.
 */
public interface AddContactView {

    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNoAdded();

}
