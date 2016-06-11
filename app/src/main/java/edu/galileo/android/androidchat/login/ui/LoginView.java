package edu.galileo.android.androidchat.login.ui;

/**
 * Created by nacheteam on 9/06/16.
 */
public interface LoginView {

    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);

}
