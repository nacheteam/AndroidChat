package edu.galileo.android.androidchat.addcontact;

import android.app.usage.UsageEvents;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.androidchat.addcontact.AddContactPresenter;
import edu.galileo.android.androidchat.addcontact.event.AddContactEvent;
import edu.galileo.android.androidchat.addcontact.ui.AddContactView;
import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;

/**
 * Created by nacheteam on 11/06/16.
 */
public class AddContactPresenterImpl implements AddContactPresenter {

    private AddContactView view;
    private EventBus eventBus;
    private AddContactInteractor interactor;

    public AddContactPresenterImpl(AddContactView view) {
        this.view = view;
        eventBus = GreenRobotEventBus.getInstance();
        this.interactor = new AddContactInteractorImpl();
    }

    @Override
    public void onShow(){
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        if(view !=null) {
            view.hideProgress();
            view.showProgress();
        }
        interactor.execute(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AddContactEvent event) {
        if(view !=null)
        {
            view.hideProgress();
            view.showInput();

            if(event.isError())
            {
                view.contactAdded();
            }
            else
            {
                view.contactAdded();
            }
        }
    }
}
