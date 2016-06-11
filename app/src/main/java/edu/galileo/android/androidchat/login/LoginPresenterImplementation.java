package edu.galileo.android.androidchat.login;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.androidchat.lib.GreenRobotEventBus;
import edu.galileo.android.androidchat.login.events.LoginEvent;
import edu.galileo.android.androidchat.login.ui.LoginView;

/**
 * Created by nacheteam on 9/06/16.
 */
public class LoginPresenterImplementation implements LoginPresenter {

    private GreenRobotEventBus eventBus;
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImplementation(LoginView loginView)
    {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
        eventBus.unregister(this);
    }

    @Override
    public void checkForAuthenticatedUser() {
        if(loginView!=null)
        {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if(loginView!=null)
        {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.doSignIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if(loginView!=null)
        {
            loginView.disableInputs();
            loginView.showProgress();
        }

        loginInteractor.doSignUp(email, password);
    }

    private void onSignInSuccess()
    {
        if (loginView!=null)
        {
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess()
    {
        if (loginView!=null)
        {
            loginView.newUserSuccess();
        }
    }
    private void onSignInError(String error)
    {
        if (loginView!=null)
        {
            loginView.enableInputs();
            loginView.hideProgress();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error)
    {
        if (loginView!=null)
        {
            loginView.enableInputs();
            loginView.hideProgress();
            loginView.newUserError(error);
        }
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType())
        {
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignUpError:
                onSignUpError(event.getErrorMessage());
                break;
            case LoginEvent.onSignInError:
                onSignInError(event.getErrorMessage());
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedToRecoverSession();
                break;

        }
    }

    private void onFailedToRecoverSession() {
        if (loginView!=null)
        {
            loginView.enableInputs();
            loginView.hideProgress();
        }
    }
}
